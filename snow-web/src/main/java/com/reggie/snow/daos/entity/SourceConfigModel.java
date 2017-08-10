package com.reggie.snow.daos.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * 数据源信息表
 * @date 2017.7.27
 * @author qingtian
 *
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SourceConfigModel implements Serializable {


  private static final long serialVersionUID = -200490649574908808L;

  private String sourceID;
  private String sourceName;
  private String sourceDesc;
  private String driverClass;
  private String sourceUrl;
  private String userName;
  private String passWord;
  private Integer type;

}
