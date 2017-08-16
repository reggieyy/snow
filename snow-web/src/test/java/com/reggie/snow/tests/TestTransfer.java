package com.reggie.snow.tests;

import static com.reggie.snow.testkit.HttpKit.apiURL;

import com.reggie.snow.testkit.IntegrationTest;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by reggie on 2017/8/15.
 */
public class TestTransfer extends IntegrationTest {

  public @Before void initDataSource(){
    System.out.println("---->");
  }

  public @Test void transfer(){
    String json = this.getRestTemplate().postForObject(apiURL("/trans/execute"), "5fb9befbf1a746c8bb07fe10303fd5ec" ,String.class);
    System.out.println(json);
  }
}
