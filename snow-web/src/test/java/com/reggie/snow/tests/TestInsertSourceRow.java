package com.reggie.snow.tests;

import static com.reggie.snow.testkit.HttpKit.apiURL;

import com.reggie.snow.daos.entity.SourceConfigModel;
import com.reggie.snow.testkit.IntegrationTest;
import java.util.UUID;
import org.junit.Test;

/**
 * Created by reggie on 2017/8/13.
 */
public class TestInsertSourceRow extends IntegrationTest {

  public @Test void insertSourceRow(){
    SourceConfigModel sourceConfigModel = new SourceConfigModel();
    sourceConfigModel.setSourceID(UUID.randomUUID().toString().replace("-",""));
    sourceConfigModel.setUserName("root");
    sourceConfigModel.setSourceName("A库");
    sourceConfigModel.setPassWord("qtrh2130");
    sourceConfigModel.setDriverClass("com.mysql.jdbc.Driver");
    sourceConfigModel.setSourceUrl("jdbc:mysql://localhost:3306/test3");
    String json = this.getRestTemplate().postForObject(apiURL("/config/insertSourceRow"), sourceConfigModel ,String.class);
    System.out.println(json);
  }
}
