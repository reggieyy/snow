package com.reggie.snow.tests;

import static com.reggie.snow.testkit.HttpKit.apiURL;

import com.reggie.snow.testkit.IntegrationTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by reggie on 2017/8/12.
 */
public class TestFindByID extends IntegrationTest {

  public @Test void findByID(){
    String json = this.getRestTemplate().getForObject(apiURL("/config/33982eda883748b0835a6d4615622fb2"), String.class);
    System.out.println(json);
  }
}
