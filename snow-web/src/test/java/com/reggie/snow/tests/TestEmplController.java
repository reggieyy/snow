package com.reggie.snow.tests;

import static com.reggie.snow.testkit.HttpKit.apiURL;

import com.reggie.snow.daos.entity.Empl;
import com.reggie.snow.testkit.IntegrationTest;
import org.junit.Test;

/**
 * Created by didi on 17/4/14.
 */
public class TestEmplController extends IntegrationTest {

    @Test
    public void emplTest() {
        Empl empl = new Empl();
        empl.setEmplID("A001");
        String json = this.getRestTemplate().postForObject(apiURL("/empl/getEmpl"), empl, String.class);
        System.out.print(json);
    }
}
