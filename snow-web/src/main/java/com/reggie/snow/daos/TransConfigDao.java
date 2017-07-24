package com.reggie.snow.daos;

import com.reggie.snow.daos.entity.TransConfigModel;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 用于配置表trans_config的dao层接口
 * @author qingtian
 * @date 2017.07.24
 */
@Mapper
public interface TransConfigDao {

  String SELECT_ALL = "select * from trans_config";
  String INSERT_ROW = "insert into trans_config (trans_id,trans_name,trans_desc,source_config,target_config,mapping_config,isvalid,isenable,type)"
      + "values (#{transID},#{transName},#{transDesc},#{sourceConfig},#{targetConfig},#{mappingConfig},#{isValid},#{isEnable},#{type})";


  @Select(SELECT_ALL)
  List<TransConfigModel> findAll(TransConfigModel transConfigModel);

  @Insert(INSERT_ROW)
  void insertRow(TransConfigModel transConfigModel);



}
