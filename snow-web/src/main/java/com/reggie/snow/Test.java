package com.reggie.snow;

import com.alibaba.fastjson.JSONObject;
import com.reggie.snow.daos.entity.SourceConfigModel;

/**
 * Created by reggie on 2017/7/27.
 */
public class Test {

  public static void main(String[] args){
    SourceConfigModel sourceConfigModel1 = new SourceConfigModel();
    sourceConfigModel1.setUserName("root");
    sourceConfigModel1.setPassWord("qtrh2130");
    sourceConfigModel1.setDriverClass("com.mysql.jdbc.Driver");
    sourceConfigModel1.setSourceUrl("jdbc:mysql://localhost:3306/test1");

    SourceConfigModel sourceConfigModel2 = new SourceConfigModel();
    sourceConfigModel2.setUserName("root");
    sourceConfigModel2.setPassWord("qtrh2130");
    sourceConfigModel2.setDriverClass("com.mysql.jdbc.Driver");
    sourceConfigModel2.setSourceUrl("jdbc:mysql://localhost:3306/test2");

    JSONObject object = (JSONObject) JSONObject.toJSON(sourceConfigModel1);
    System.out.print(object.toJSONString());
    SourceConfigModel s = JSONObject.toJavaObject(object,SourceConfigModel.class);
    System.out.print(s.getDriverClass());
  }
}
