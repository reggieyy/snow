package com.reggie.snow.tests;

import static com.reggie.snow.testkit.HttpKit.apiURL;

import com.reggie.snow.daos.entity.ConfigDto;
import com.reggie.snow.daos.entity.MappingConfigModel;
import com.reggie.snow.daos.entity.TransConfigModel;
import com.reggie.snow.testkit.IntegrationTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;

/**
 * Created by reggie on 2017/8/14.
 */
public class TestInsertTransConfig extends IntegrationTest {

  public @Test void insertTransConfig(){
    TransConfigModel transConfigModel = new TransConfigModel();
    transConfigModel.setTransID(UUID.randomUUID().toString().replace("-",""));
    transConfigModel.setTransName("数据中转");
    transConfigModel.setTransDesc("this is a test!");
    transConfigModel.setSourceConfigID("80d3c1d3807643a4863bd60f6813a552");
    transConfigModel.setTargetConfigID("43f31b6c927d4af5977e97044c663aa4");
    transConfigModel.setIsValid(0);
    transConfigModel.setIsEnable(0);
    transConfigModel.setType(0);
    transConfigModel.setSourceTable("user_info");
    transConfigModel.setTargetTable("empl_info");

    MappingConfigModel m1 = new MappingConfigModel();
    m1.setTransID(transConfigModel.getTransID());
    m1.setFromField("name");
    m1.setFromFieldName("姓名");
    m1.setToField("empl_name");
    m1.setToFieldName("员工名称");
    MappingConfigModel m2 = new MappingConfigModel();
    m2.setTransID(transConfigModel.getTransID());
    m2.setFromField("code");
    m2.setFromFieldName("编码");
    m2.setToField("empl_code");
    m2.setToFieldName("员工编号");
    List<MappingConfigModel> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);

    ConfigDto config = new ConfigDto();
    config.setTransConfigModel(transConfigModel);
    config.setMappingConfigModelList(list);
    String json = this.getRestTemplate().postForObject(apiURL("/config/insertRow"),config,String.class);
    System.out.println(json);
  }
}
