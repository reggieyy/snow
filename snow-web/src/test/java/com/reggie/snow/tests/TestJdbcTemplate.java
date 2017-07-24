package com.reggie.snow.tests;

import java.util.List;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 * Created by reggie on 2017/7/24.
 */

public class TestJdbcTemplate {

  private JdbcTemplate jdbcTemplate;

  public @Test void test(){
    BasicDataSource basicDataSource = new BasicDataSource();

    // 基本4项
    basicDataSource.setDriverClassName("com.mysql.jdbc.Driver"); // 加载驱动
    basicDataSource.setUrl("jdbc:mysql://localhost:3306/test1");  // 数据库的
    basicDataSource.setUsername("root");
    basicDataSource.setPassword("qtrh2130");
    basicDataSource.setMaxActive(8);

    jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(basicDataSource);
    List list = jdbcTemplate.queryForList("select id,name from test1_t");
    System.out.print(list);
  }

}
