package com.reggie.snow.tests;

import static com.reggie.snow.testkit.HttpKit.apiURL;

import com.alibaba.fastjson.JSONObject;
import com.reggie.snow.daos.entity.ConfigDto;
import com.reggie.snow.daos.entity.MappingConfigModel;
import com.reggie.snow.daos.entity.SourceConfigModel;
import com.reggie.snow.daos.entity.TransConfigModel;
import com.reggie.snow.testkit.IntegrationTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.eclipse.jetty.util.StringUtil;
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
    add();
//    get();
//    update();
//    delete();
  }

  private void select(){
    TransConfigModel transConfigModel = new TransConfigModel();
    String json = this.getRestTemplate().postForObject(apiURL("/config/findAll"), transConfigModel, String.class);
    System.out.print(json);
  }

  private void add(){

    SourceConfigModel sourceConfigModel1 = new SourceConfigModel();
    sourceConfigModel1.setSourceID(UUID.randomUUID().toString().replace("-",""));
    sourceConfigModel1.setUserName("root");
    sourceConfigModel1.setSourceName("A库");
    sourceConfigModel1.setPassWord("qtrh2130");
    sourceConfigModel1.setDriverClass("com.mysql.jdbc.Driver");
    sourceConfigModel1.setSourceUrl("jdbc:mysql://localhost:3306/test1");
    sourceConfigModel1.setType(0);

    SourceConfigModel sourceConfigModel2 = new SourceConfigModel();
    sourceConfigModel2.setSourceID(UUID.randomUUID().toString().replace("-",""));
    sourceConfigModel2.setUserName("root");
    sourceConfigModel2.setSourceName("B库");
    sourceConfigModel2.setPassWord("qtrh2130");
    sourceConfigModel2.setDriverClass("com.mysql.jdbc.Driver");
    sourceConfigModel2.setSourceUrl("jdbc:mysql://localhost:3306/test2");
    sourceConfigModel2.setType(1);

    List<SourceConfigModel> list_s = new ArrayList<>();
    list_s.add(sourceConfigModel1);
    list_s.add(sourceConfigModel2);

    TransConfigModel transConfigModel = new TransConfigModel();
    transConfigModel.setTransID(UUID.randomUUID().toString().replace("-",""));
    transConfigModel.setTransName("数据中转");
    transConfigModel.setTransDesc("this is a test!");
    transConfigModel.setIsValid(0);
    transConfigModel.setIsEnable(0);
    transConfigModel.setType(0);
    transConfigModel.setSourceTable("user_info");
    transConfigModel.setTargetTable("empl_info");

    MappingConfigModel mappingConfigModel = new MappingConfigModel();
    mappingConfigModel.setTransID(transConfigModel.getTransID());
    mappingConfigModel.setFromField("name");
    mappingConfigModel.setFromFieldName("姓名");
    mappingConfigModel.setToField("empl_name");
    mappingConfigModel.setToFieldName("员工名称");

    List<MappingConfigModel> list_m = new ArrayList<>();
    list_m.add(mappingConfigModel);

    ConfigDto config = new ConfigDto();
    config.setTransConfigModel(transConfigModel);
    config.setMappingConfigModelList(list_m);
    config.setSourceConfigModelList(list_s);


//    this.getRestTemplate().put(apiURL("/config/insertRow"),transConfigModel);

//    ResponseEntity<String> exchange = this.getRestTemplate().exchange(apiURL("/config/insertRow"),HttpMethod.PUT,
//        new HttpEntity<Object>(transConfigModel),String.class);
//    System.out.print(exchange.getBody());
    String json = this.getRestTemplate().postForObject(apiURL("/config/insertRow"), config, String.class);
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
