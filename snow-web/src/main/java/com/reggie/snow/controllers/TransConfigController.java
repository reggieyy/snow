package com.reggie.snow.controllers;

import com.alibaba.fastjson.JSONObject;
import com.reggie.snow.daos.entity.TransConfigModel;
import com.reggie.snow.services.TransConfigService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 核心配置表对外restful接口
 * @date 2017.7.27
 * @author qingtian
 *
 */
@RestController
@RequestMapping("/config")
@Slf4j
public class TransConfigController {

  @Autowired
  private TransConfigService transConfigService;

  @ApiOperation(value="查询所有配置", notes="查询所有转数配置信息,返回list")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "transConfigModel", value = "配置类", required = true, dataType = "TransConfigModel")
  })
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

  @ApiOperation(value="新增配置信息", notes="向核心配置表插入一条配置信息，插入信息需要包含配置描述，数据源信息，mapping关系")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "transConfigModel", value = "配置类", required = true, dataType = "TransConfigModel")
  })
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

  @ApiOperation(value="查询单条配置信息", notes="根据transID查询单条配置信息,返回Object")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "transID", value = "配置ID", required = true, dataType = "String")
  })
  @RequestMapping(value = "/{transID}",method = RequestMethod.GET)
  public ResponseEntity<JSONObject> findByID(@PathVariable String transID){
    JSONObject object = new JSONObject();
    try {
      TransConfigModel transConfigModel = transConfigService.findByID(transID);
      object.put("model", transConfigModel);
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    } catch (Exception e) {
      log.error("新增配置信息异常{}", e);
      object.put("model", null);
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    }
  }

  @ApiOperation(value="更新配置信息", notes="更新/无效配置信息，参数为配置类")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "transConfigModel", value = "配置类", required = true, dataType = "TransConfigModel")
  })
  @RequestMapping(value = "/updateRow", method = RequestMethod.PUT)
  public ResponseEntity<JSONObject> updateRow(@RequestBody TransConfigModel transConfigModel){
    JSONObject object = new JSONObject();
    try {
      transConfigService.updateRow(transConfigModel);
      object.put("flag", true);
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    } catch (Exception e) {
      log.error("更新配置信息异常{}", e);
      object.put("flag", false);
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    }
  }

  @ApiOperation(value="删除配置信息", notes="从数据库中删除配置信息")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "transID", value = "配置ID", required = true, dataType = "String")
  })
  @RequestMapping(value = "/deleteRow/{transID}", method = RequestMethod.DELETE)
  public ResponseEntity<JSONObject> updateRow(@PathVariable String transID){
    JSONObject object = new JSONObject();
    try {
      transConfigService.deleteRow(transID);
      object.put("flag", true);
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    } catch (Exception e) {
      log.error("删除配置信息异常{}", e);
      object.put("flag", false);
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    }
  }

}
