package com.reggie.snow.services;

import com.alibaba.fastjson.JSONObject;
import com.reggie.snow.daos.TransConfigDao;
import com.reggie.snow.daos.entity.ConfigDto;
import com.reggie.snow.daos.entity.MappingConfigModel;
import com.reggie.snow.daos.entity.SourceConfigModel;
import com.reggie.snow.daos.entity.TransConfigModel;
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

  /**
   * 配置信息写入，数据源信息需要单独保存
   * @param configDto
   */
//  @Transactional
  public void insertRow(ConfigDto configDto) {
//    JSONObject.toJavaObject();
    List<SourceConfigModel> list_s = configDto.getSourceConfigModelList();
    List<MappingConfigModel> list_m = configDto.getMappingConfigModelList();
    if(!list_s.isEmpty()){
      list_s.stream().forEach((sourceConfigModel) -> {
        if(1 == sourceConfigModel.getType()){
          configDto.getTransConfigModel().setSourceConfigID(sourceConfigModel.getSourceID());
        }else{
          configDto.getTransConfigModel().setTargetConfigID(sourceConfigModel.getSourceID());
        }
        transConfigDao.insertSourceConfigRow(sourceConfigModel);
      });
    }
    transConfigDao.insertRow(configDto.getTransConfigModel());
    if(!list_m.isEmpty()){
      list_m.stream().forEach((mappingConfigModel) -> {
        mappingConfigModel.setTransID(configDto.getTransConfigModel().getTransID());
        transConfigDao.insertMappingRow(mappingConfigModel);
      });
    }

  }

  public TransConfigModel findByID(String transID){
    log.info("transID-----------"+transID);
    TransConfigModel t = transConfigDao.findByID(transID);
    return t;
  }

  public void updateRow(TransConfigModel transConfigModel){
    transConfigDao.updateRow(transConfigModel);
  }

  public void deleteRow(String transID){
    transConfigDao.deleteRow(transID);
  }
}
