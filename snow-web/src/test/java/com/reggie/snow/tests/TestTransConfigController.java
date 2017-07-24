package com.reggie.snow.tests;

import static com.reggie.snow.testkit.HttpKit.apiURL;

import com.reggie.snow.daos.entity.TransConfigModel;
import com.reggie.snow.testkit.IntegrationTest;
import java.util.UUID;
import org.junit.Test;

/**
 * Created by reggie on 2017/7/24.
 */
public class TestTransConfigController extends IntegrationTest {
  @Test
  public void emplTest() {
        select();
//    add();

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
    String json = this.getRestTemplate().postForObject(apiURL("/config/insertRow"), transConfigModel, String.class);
    System.out.print(json);
  }

}
