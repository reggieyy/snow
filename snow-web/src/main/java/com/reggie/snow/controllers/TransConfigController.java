package com.reggie.snow.controllers;

import com.alibaba.fastjson.JSONObject;
import com.reggie.snow.daos.entity.Empl;
import com.reggie.snow.daos.entity.TransConfigModel;
import com.reggie.snow.services.TransConfigService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by reggie on 2017/7/24.
 */
@RestController
@RequestMapping("/config")
@Slf4j
public class TransConfigController {

  @Autowired
  private TransConfigService transConfigService;

  @RequestMapping(value = "/findAll", method = RequestMethod.POST)
  public ResponseEntity<JSONObject> findEmpls(@RequestBody TransConfigModel transConfigModel) {
    JSONObject object = new JSONObject();
    try {
      List<TransConfigModel> result = transConfigService.findAll(transConfigModel);
      object.put("config", result);
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    } catch (Exception e) {
      log.error("查询配置信息异常{}", e);
      object.put("config", "null");
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    }
  }

  @RequestMapping(value = "/insertRow", method = RequestMethod.POST)
  public ResponseEntity<JSONObject> insertRow(@RequestBody TransConfigModel transConfigModel) {
    JSONObject object = new JSONObject();
    try {
      transConfigService.insertRow(transConfigModel);
      object.put("flag", true);
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    } catch (Exception e) {
      log.error("新增配置信息异常{}", e);
      object.put("flag", false);
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    }
  }

}
