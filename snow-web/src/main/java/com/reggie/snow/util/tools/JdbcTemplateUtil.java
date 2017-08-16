package com.reggie.snow.util.tools;

import com.reggie.snow.daos.entity.SourceConfigModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by reggie on 2017/8/13.
 */
public class JdbcTemplateUtil {

  public static Map<String,JdbcTemplate> jdbcMap = new HashMap<>();

  /**
   * 校验数据源是否可用，如果可用保存到静态map中
   * @param sourceConfigModel
   * @return
   * @throws SQLException
   */
  public static JdbcTemplate checkDataSource(SourceConfigModel sourceConfigModel) {
    BasicDataSource basicDataSource = new BasicDataSource();
    // 基本4项
    basicDataSource.setDriverClassName(sourceConfigModel.getDriverClass());
    basicDataSource.setUrl(sourceConfigModel.getSourceUrl());
    basicDataSource.setUsername(sourceConfigModel.getUserName());
    basicDataSource.setPassword(sourceConfigModel.getPassWord());
//    basicDataSource.setMaxActive(8);

    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(basicDataSource);
    try{
      List list = jdbcTemplate.queryForList("select 1 from dual");
      if(list.size() > 0) {
        jdbcMap.put(sourceConfigModel.getSourceID(),jdbcTemplate);
        return jdbcTemplate;
      }
    } catch (Exception e){
      throw new RuntimeException("该数据源无法使用，请检查配置是否正确...");
    }
    return null;
  }
}
