package com.reggie.snow.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.LinkedCaseInsensitiveMap;

/**
 * Created by reggie on 2017/7/24.
 */

public class TestJdbcTemplate {

  private JdbcTemplate jdbcTemplate;

  public void dataSourceValid() throws SQLException {
    BasicDataSource basicDataSource = new BasicDataSource();

    // 基本4项
    basicDataSource.setDriverClassName("com.mysql.jdbc.Driver"); // 加载驱动
    basicDataSource.setUrl("jdbc:mysql://localhost:3306/test1");  // 数据库的
    basicDataSource.setUsername("root");
    basicDataSource.setPassword("qtrh2130");
    basicDataSource.setMaxActive(8);

    jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(basicDataSource);
    Map map = new HashMap<>();
    map.put("1",jdbcTemplate);
    JdbcTemplate jdbcTemplate1 = (JdbcTemplate) map.get("1");
    List list = jdbcTemplate1.queryForList("select 1 from dual");

    if(list.size() > 0){
      System.out.print(list);
      Connection connection = jdbcTemplate1.getDataSource().getConnection();
      System.out.println(connection.isClosed());
      connection.close();
      System.out.println(connection.isClosed());
      List list1 = jdbcTemplate1.queryForList("select 1 from dual");
      System.out.print(list1);
    }else{
      System.out.print(0);
    }
  }

  public @Test void test(){
    BasicDataSource basicDataSource = new BasicDataSource();

    // 基本4项
    basicDataSource.setDriverClassName("com.mysql.jdbc.Driver"); // 加载驱动
    basicDataSource.setUrl("jdbc:mysql://localhost:3306/snow");  // 数据库的
    basicDataSource.setUsername("root");
    basicDataSource.setPassword("qtrh2130");
    basicDataSource.setMaxActive(8);

    jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(basicDataSource);
    Map map = new HashMap<>();
    map.put("1",jdbcTemplate);
    JdbcTemplate jdbcTemplate1 = (JdbcTemplate) map.get("1");
    List<Map<String, Object>> list = jdbcTemplate1.queryForList("select * from mapping_config");
    list.forEach(map_i -> {
      System.out.println(map_i.get("to_field_name"));
    });
  }

}
