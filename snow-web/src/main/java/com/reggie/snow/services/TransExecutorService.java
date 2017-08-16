package com.reggie.snow.services;

import com.reggie.snow.daos.TransConfigDao;
import com.reggie.snow.daos.entity.MappingConfigModel;
import com.reggie.snow.daos.entity.SourceConfigModel;
import com.reggie.snow.daos.entity.TransConfigModel;
import com.reggie.snow.util.CommonUtil;
import com.reggie.snow.util.tools.JdbcTemplateUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.xml.transform.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 转数执行器
 * @date 2017.07.26
 * @author qingtian
 *
 */
@Service
public class TransExecutorService {

  @Autowired
  private TransConfigDao transConfigDao;

  static int SEGMENT_SIZE = 100;

  /**
   * 执行器
   * 1.根据transID获取转数配置
   * 2.是否已经存在连接池，如存在直接调用，如不存在则新建连接池再调用
   * 3.事务不适用autoCommit，通过getConnection自主进行事务提交
   * @param transID
   */
  public void execute(String transID) {
    List<MappingConfigModel> mappingConfigModelList = null;
    TransConfigModel transConfigModel = transConfigDao.findTransConfigByID(transID);
    String selectSQL;
    if((selectSQL =CommonUtil.sqlMap.get(transID)) == null){
      mappingConfigModelList = transConfigDao.findMappingConfigByID(transID);
      if(mappingConfigModelList != null && mappingConfigModelList.size() > 0){
        selectSQL = this.selectSQL(transConfigModel,mappingConfigModelList);
        CommonUtil.sqlMap.put(transID,selectSQL);
      }else {
        throw new RuntimeException("没有映射，无法转数...");
      }
    }
    JdbcTemplate sourceJdbcTemplate = this.getJdbcTemplate(transConfigModel.getSourceConfigID());
    JdbcTemplate targetJdbcTemplate = this.getJdbcTemplate(transConfigModel.getTargetConfigID());

    List<Map<String, Object>> list = sourceJdbcTemplate.queryForList(selectSQL);

    this.insert(targetJdbcTemplate, transConfigModel, mappingConfigModelList, list);

  }

  /**
   * 获取jdbcTemplate实例，如果没能在缓存中命中，则创建新的实例
   * @param source_id
   * @return
   */
  private JdbcTemplate getJdbcTemplate(String source_id){
    JdbcTemplate jdbcTemplate = JdbcTemplateUtil.jdbcMap.get(source_id);
    if(jdbcTemplate == null){
      SourceConfigModel sourceConfigModel = transConfigDao.findSourceConfigByID(source_id);
      jdbcTemplate = JdbcTemplateUtil.checkDataSource(sourceConfigModel);
    }
    return jdbcTemplate;
  }

  public static void main(String[] args){
    System.out.println(11/100);
  }

  /**
   * 插入数据
   * @param jdbcTemplate
   * @param transConfigModel
   * @param mappingConfigModelList
   * @param list
   */
  private void insert(JdbcTemplate jdbcTemplate,TransConfigModel transConfigModel,
      List<MappingConfigModel> mappingConfigModelList,List<Map<String, Object>> list){
    int num = pageNum(list.size(),SEGMENT_SIZE);
    for(int i=0;i<num;i++){
      int LOCAL_SEGMENT_SIZE = SEGMENT_SIZE;
      if(i == num-1){//最后一页需要精确计算
        LOCAL_SEGMENT_SIZE = list.size()-(i*SEGMENT_SIZE);
      }
      jdbcTemplate.update(this.insertSQL(transConfigModel, mappingConfigModelList, list.subList(i*SEGMENT_SIZE,LOCAL_SEGMENT_SIZE)));
    }
  }

  /**
   * 计算分页数
   * @param total
   * @param pageSize
   * @return
   */
  private int pageNum(int total,int pageSize){
    return total%pageSize > 0 ? (total/pageSize)+1 : total/pageSize;
  }

  /**
   * 组织插入语句
   * @param transConfigModel
   * @param key_list
   * @param value_list
   * @return
   */
  private String insertSQL(TransConfigModel transConfigModel,List<MappingConfigModel> key_list,List<Map<String,Object>> value_list){
    StringBuffer fieldBuffer = new StringBuffer();
    StringBuffer valueBuffer = new StringBuffer();
    StringBuffer finalBuffer = new StringBuffer();
    key_list.stream().sorted().forEach(mappingConfigModel -> {
      fieldBuffer.append(mappingConfigModel.getToField()).append(",");
    });
    fieldBuffer.deleteCharAt(fieldBuffer.length()-1);
    String[] field_array = fieldBuffer.toString().split(",");
    value_list.forEach((map) -> {
      valueBuffer.append(" ( ");
      for(int j=0;j<field_array.length;j++){
        valueBuffer.append("'").append(map.get(field_array[j])).append("',");
      }
      valueBuffer.deleteCharAt(valueBuffer.length()-1);
      valueBuffer.append(" ),");
    });
    valueBuffer.deleteCharAt(valueBuffer.length()-1);

    finalBuffer.append("insert into ").append(transConfigModel.getTargetTable())
               .append(" ( ").append(fieldBuffer).append(" ) ")
               .append(" values ").append(valueBuffer);

    return finalBuffer.toString();
  }

  /**
   * 组织查询语句
   * @param list
   * @return
   */
  private String selectSQL(TransConfigModel transConfigModel,List<MappingConfigModel> list){
    StringBuffer buffer = new StringBuffer();
    buffer.append("select  ");
    list.stream().sorted().forEach((mappingConfigModel) -> {
      buffer.append(" ")
            .append(mappingConfigModel.getFromField())
            .append(" as ")
            .append(mappingConfigModel.getToField())
            .append(",");
    });
    buffer.deleteCharAt(buffer.length()-1);
    buffer.append(" from ").append(transConfigModel.getSourceTable());
    return buffer.toString();
  }
}
