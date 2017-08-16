package com.reggie.snow.daos;

import com.reggie.snow.daos.entity.MappingConfigModel;
import com.reggie.snow.daos.entity.SourceConfigModel;
import com.reggie.snow.daos.entity.TransConfigModel;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
  String SELECT_TRANSCONFIG_BY_ID = "select * from trans_config where trans_id = #{transID}";
  String SELECT_SOURCECONFIG_BY_ID = "select * from source_config where source_id = #{source_id}";
  String SELECT_MAPPINGCONFIG_BY_ID = "select * from mapping_config where trans_id = #{transID}";
  //删除核心配置表数据
  String DELETE_ROW = "delete from trans_config where trans_id = #{transID}";
  //数据源信息表插入数据
  String INSERT_SOURCE_CONFIG_ROW = "insert into source_config (source_id,source_name,source_desc,driver_class,source_url,username,password)"
      + "values (#{sourceID},#{sourceName},#{sourceDesc},#{driverClass},#{sourceUrl},#{userName},#{passWord})";
  String BATCH_INSERT_MAPPING_ROW = "<script>insert into mapping_config (trans_id,from_field,from_field_name,to_field,to_field_name) "
      + "values <foreach collection=\"mappingConfigModels\" item=\"mapping\" index=\"index\" separator=\",\">"
      + "(#{mapping.transID},#{mapping.fromField},#{mapping.fromFieldName},#{mapping.toField},#{mapping.toFieldName})</foreach></script>";

  @Select(SELECT_ALL)
  @ResultMap("transConfig")
  List<TransConfigModel> findAll(TransConfigModel transConfigModel);

  @Insert(INSERT_ROW)
  void insertRow(TransConfigModel transConfigModel);

  @Select(SELECT_TRANSCONFIG_BY_ID)
  @Results(id = "transConfig", value = {
      @Result(property="transID",column="trans_id"),
      @Result(property="transName",column="trans_name"),
      @Result(property="transDesc",column="trans_desc"),
      @Result(property="sourceConfigID",column="source_config_id"),
      @Result(property="targetConfigID",column="target_config_id"),
      @Result(property="isValid",column="isvalid"),
      @Result(property="isEnable",column="isenable"),
      @Result(property="type",column="type"),
      @Result(property="sourceTable",column="source_table"),
      @Result(property="targetTable",column="target_table")
  })
  TransConfigModel findTransConfigByID(String transID);

  @Select(SELECT_SOURCECONFIG_BY_ID)
  @Results(id="sourceConfig", value = {
      @Result(property = "sourceID",column = "source_id"),
      @Result(property = "sourceName",column = "source_name"),
      @Result(property = "sourceDesc",column = "source_desc"),
      @Result(property = "driverClass",column = "driver_class"),
      @Result(property = "sourceUrl",column = "source_url"),
      @Result(property = "userName",column = "username"),
      @Result(property = "passWord",column = "password"),
      @Result(property = "type",column = "type")
  })
  SourceConfigModel findSourceConfigByID(String sourceID);

  @Select(SELECT_MAPPINGCONFIG_BY_ID)
  @Results(id="mappingConfig", value = {
      @Result(property = "transID",column = "trans_id"),
      @Result(property = "fromField",column = "from_field"),
      @Result(property = "fromFieldName",column = "from_field_name"),
      @Result(property = "toField",column = "to_field"),
      @Result(property = "toFieldName",column = "to_field_name")
  })
  List<MappingConfigModel> findMappingConfigByID(String transID);

  void updateRow(TransConfigModel transConfigModel);

  @Delete(DELETE_ROW)
  void deleteRow(String transID);

  @Insert(INSERT_SOURCE_CONFIG_ROW)
  void insertSourceConfigRow(SourceConfigModel sourceConfigModel);

  @Insert(BATCH_INSERT_MAPPING_ROW)
  void batchInsertMappingRow(@Param("mappingConfigModels") List<MappingConfigModel> mappingConfigModels);


}
