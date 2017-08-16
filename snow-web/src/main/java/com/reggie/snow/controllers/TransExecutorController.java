package com.reggie.snow.controllers;

import com.alibaba.fastjson.JSONObject;
import com.reggie.snow.services.TransExecutorService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 执行器restful接口
 * @date 2017.7.27
 * @author qingtian
 *
 */
@RestController
@RequestMapping("trans")
@Slf4j
public class TransExecutorController {

  @Autowired
  TransExecutorService transExecutorService;

  @ApiOperation(value = "执行配置", notes = "执行转数过程")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "transID",value = "配置编码",required = true,dataType = "string")
  })
  @RequestMapping(value = "/execute", method = RequestMethod.POST)
  public ResponseEntity<JSONObject> transfer(@RequestBody String transID){
    JSONObject object = new JSONObject();
    try {

      transExecutorService.execute(transID);

      object.put("flag",true);
    }catch (Exception e){
      object.put("msg",e.getMessage());
      object.put("flag",false);
    }finally {
      return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    }
  }
}
