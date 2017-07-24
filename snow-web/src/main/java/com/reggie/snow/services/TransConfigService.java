package com.reggie.snow.services;

import com.reggie.snow.daos.EmplDao;
import com.reggie.snow.daos.TransConfigDao;
import com.reggie.snow.daos.entity.TransConfigModel;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public void insertRow(TransConfigModel transConfigModel) {
    transConfigDao.insertRow(transConfigModel);
  }
}
