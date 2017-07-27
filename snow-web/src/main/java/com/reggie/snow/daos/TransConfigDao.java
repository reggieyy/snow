package com.reggie.snow.daos;

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

  String SELECT_ALL = "select * from trans_config";
  String INSERT_ROW = "insert into trans_config (trans_id,trans_name,trans_desc,source_config,target_config,mapping_config,isvalid,isenable,type)"
      + "values (#{transID},#{transName},#{transDesc},#{sourceConfig},#{targetConfig},#{mappingConfig},#{isValid},#{isEnable},#{type})";
  String SELECT_BY_ID = "select * from trans_config where trans_id = #{transID}";
  String DELETE_ROW = "delete from trans_config where trans_id = #{transID}";


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

}
