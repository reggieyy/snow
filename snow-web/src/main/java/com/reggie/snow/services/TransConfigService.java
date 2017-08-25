package com.reggie.snow.services;

import com.alibaba.fastjson.JSONObject;
import com.reggie.snow.daos.TransConfigDao;
import com.reggie.snow.daos.entity.ConfigDto;
import com.reggie.snow.daos.entity.GroupConfigModel;
import com.reggie.snow.daos.entity.MappingConfigModel;
import com.reggie.snow.daos.entity.SourceConfigModel;
import com.reggie.snow.daos.entity.TransConfigModel;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by reggie on 2017/7/24.
 */
@Service
@Slf4j
public class TransConfigService {

  @Autowired
  private TransConfigDao transConfigDao;

  public List<TransConfigModel> findAll(TransConfigModel transConfigModel){
    return transConfigDao.findAll(transConfigModel);
  }

  public List<GroupConfigModel> findGroupConfigs(GroupConfigModel groupConfigModel){
    return transConfigDao.findGroupConfigs(groupConfigModel);
  }

  public void insertGroupConfigRow(GroupConfigModel groupConfigModel){
    transConfigDao.insertGroupConfigrRow(groupConfigModel);
  }


  /**
   *
   * 根据transID查询对应转数配置
   * @param transID
   * @return config
   *
   */
  public ConfigDto findByID(String transID){
    //配置主表信息
    TransConfigModel transConfigModel = transConfigDao.findTransConfigByID(transID);
    if(transConfigModel == null){
      throw new RuntimeException("没有查询到对应数据");
    }
    //数据源信息
    List<SourceConfigModel> list_s = new ArrayList<>();
    list_s.add(transConfigDao.findSourceConfigByID(transConfigModel.getSourceConfigID()));
    list_s.add(transConfigDao.findSourceConfigByID(transConfigModel.getTargetConfigID()));
    //mapping表信息
    List<MappingConfigModel> list_m = transConfigDao.findMappingConfigByID(transID);
    ConfigDto config = new ConfigDto();
    config.setTransConfigModel(transConfigModel);
    config.setSourceConfigModelList(list_s);
    config.setMappingConfigModelList(list_m);
    return config;
  }

  /**
   * 配置信息写入，数据源信息需要单独保存
   * @param configDto
   */
  @Transactional
  public void insertRow(ConfigDto configDto) {
//    JSONObject.toJavaObject();
    List<MappingConfigModel> list_m = configDto.getMappingConfigModelList();
    transConfigDao.insertRow(configDto.getTransConfigModel());
    if(!list_m.isEmpty()){
      list_m.stream().forEach((mappingConfigModel) -> {
        mappingConfigModel.setTransID(configDto.getTransConfigModel().getTransID());
      });
    }
    transConfigDao.batchInsertMappingRow(list_m);
  }

  public void insertSrouceConfigRow(SourceConfigModel sourceConfigModel){
    transConfigDao.insertSourceConfigRow(sourceConfigModel);
  }

  public TransConfigModel findTransConfigByID(String transID){
    log.info("transID-----------"+transID);
    TransConfigModel t = transConfigDao.findTransConfigByID(transID);
    return t;
  }

  @Transactional
  public void updateRow(ConfigDto configDto){



//    transConfigDao.updateRow(transConfigModel);
  }

  public void deleteRow(String transID){
    transConfigDao.deleteRow(transID);
  }
}
