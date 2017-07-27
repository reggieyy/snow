package com.reggie.snow.tests;

import static com.reggie.snow.testkit.HttpKit.apiURL;

import com.reggie.snow.daos.entity.TransConfigModel;
import com.reggie.snow.testkit.IntegrationTest;
import java.util.UUID;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

/**
 * Created by reggie on 2017/7/24.
 */
public class TestTransConfigController extends IntegrationTest {
  @Test
  public void emplTest() {
//        select();
//    add();
//    get();
//    update();
    delete();
  }

  private void select(){
    TransConfigModel transConfigModel = new TransConfigModel();
    String json = this.getRestTemplate().postForObject(apiURL("/config/findAll"), transConfigModel, String.class);
    System.out.print(json);
  }

  private void add(){
    TransConfigModel transConfigModel = new TransConfigModel();
    transConfigModel.setTransID(UUID.randomUUID().toString().replace("-",""));
    transConfigModel.setTransName("数据中转");
    transConfigModel.setTransDesc("this is a test!");
    transConfigModel.setSourceConfig("test");
    transConfigModel.setTargetConfig("test");
    transConfigModel.setMappingConfig("test");
    transConfigModel.setIsValid(0);
    transConfigModel.setIsEnable(0);
    transConfigModel.setType(0);
//    this.getRestTemplate().put(apiURL("/config/insertRow"),transConfigModel);

//    ResponseEntity<String> exchange = this.getRestTemplate().exchange(apiURL("/config/insertRow"),HttpMethod.PUT,
//        new HttpEntity<Object>(transConfigModel),String.class);
//    System.out.print(exchange.getBody());
    String json = this.getRestTemplate().postForObject(apiURL("/config/insertRow"), transConfigModel, String.class);
    System.out.print(json);
  }

  private void get(){
    String json = this.getRestTemplate().getForObject(apiURL("/config/97ac5e23b5f44110868d7d027b3298cf"), String.class);
    System.out.print(json);
  }

  private void update(){
    TransConfigModel transConfigModel = new TransConfigModel();
    transConfigModel.setTransID("97ac5e23b5f44110868d7d027b3298cf");
    transConfigModel.setTransName("测试从xml文件能否切入");
    ResponseEntity<String> exchange = this.getRestTemplate().exchange(apiURL("/config/updateRow"), HttpMethod.PUT,
        new HttpEntity<Object>(transConfigModel), String.class);
    System.out.print(exchange.getBody());
  }

  private void delete(){
    ResponseEntity<String> exchange = this.getRestTemplate().exchange(apiURL("/config/deleteRow/97ac5e23b5f44110868d7d027b3298cf"), HttpMethod.DELETE,
        null ,String.class);
    System.out.print(exchange.getBody());
  }

}
