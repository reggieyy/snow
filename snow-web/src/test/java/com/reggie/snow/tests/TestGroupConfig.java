package com.reggie.snow.tests;

import static com.reggie.snow.testkit.HttpKit.apiURL;

import com.reggie.snow.daos.entity.GroupConfigModel;
import com.reggie.snow.testkit.IntegrationTest;
import org.junit.Test;

/**
 * Created by reggie on 2017/8/23.
 */
public class TestGroupConfig extends IntegrationTest {

  public @Test void test(){
    GroupConfigModel groupConfigModel = new GroupConfigModel();
    groupConfigModel.setGroupID("G001");
    groupConfigModel.setGroupName("测试分组");
    groupConfigModel.setGroupDesc("这是一个测试用的分组");
    groupConfigModel.setIsValid(1);

    String json = this.getRestTemplate().postForObject(apiURL("/config/insertGroupConfigRow"),groupConfigModel,String.class);
    System.out.println(json);
  }
}
