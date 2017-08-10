package com.reggie.snow.daos;

import com.reggie.snow.daos.entity.MappingConfigModel;
import com.reggie.snow.daos.entity.SourceConfigModel;
import com.reggie.snow.daos.entity.TransConfigModel;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *
 * 用于核心配置表trans_config的dao层接口
 * @date 2017.07.24
 * @author qingtian
 *
 */
@Mapper
public interface TransConfigDao {

  //查询所有
  String SELECT_ALL = "select * from trans_config";
  //核心配置表插入数据
  String INSERT_ROW = "insert into trans_config (trans_id,trans_name,trans_desc,source_config_id,target_config_id,source_target_sql,isvalid,isenable,type,source_table,target_table)"
      + "values (#{transID},#{transName},#{transDesc},#{sourceConfigID},#{targetConfigID},#{sourceTargetSql},#{isValid},#{isEnable},#{type},#{sourceTable},#{targetTable})";
  //根据配置ID查询单条配置表记录
  String SELECT_BY_ID = "select * from trans_config where trans_id = #{transID}";
  //删除核心配置表数据
  String DELETE_ROW = "delete from trans_config where trans_id = #{transID}";
  //数据源信息表插入数据
  String INSERT_SOURCE_CONFIG_ROW = "insert into source_config (source_id,source_name,source_desc,driver_class,source_url,username,password)"
      + "values (#{sourceID},#{sourceName},#{sourceDesc},#{driverClass},#{sourceUrl},#{userName},#{passWord})";
  String INSERT_MAPPING_ROW = "insert into mapping_config (trans_id,from_field,from_field_name,to_field,to_field_name) "
      + "values (#{transID},#{fromField},#{fromFieldName},#{toField},#{toFieldName})";

  @Select(SELECT_ALL)
  @ResultMap("transConfig")
  List<TransConfigModel> findAll(TransConfigModel transConfigModel);

  @Insert(INSERT_ROW)
  void insertRow(TransConfigModel transConfigModel);

  @Select(SELECT_BY_ID)
  @Results(id = "transConfig", value = {
      @Result(property="transID",column="trans_id"),
      @Result(property="transName",column="trans_name"),
      @Result(property="transDesc",column="trans_desc"),
      @Result(property="sourceConfig",column="source_config"),
      @Result(property="targetConfig",column="target_config"),
      @Result(property="mappingConfig",column="mapping_config"),
      @Result(property="isValid",column="isvalid"),
      @Result(property="isEnable",column="isenable"),
      @Result(property="type",column="type")
  })
  TransConfigModel findByID(String transID);

  void updateRow(TransConfigModel transConfigModel);

  @Delete(DELETE_ROW)
  void deleteRow(String transID);

  @Insert(INSERT_SOURCE_CONFIG_ROW)
  void insertSourceConfigRow(SourceConfigModel sourceConfigModel);

  @Insert(INSERT_MAPPING_ROW)
  void insertMappingRow(MappingConfigModel mappingConfigModel);
}
