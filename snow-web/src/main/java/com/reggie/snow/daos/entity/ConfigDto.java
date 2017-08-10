package com.reggie.snow.daos.entity;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 配置大对象，用于接收标准格式的json串
 * @date 2017.7.30
 * @author qingtian
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfigDto implements Serializable {

  private static final long serialVersionUID = 4193946971028909764L;

  private TransConfigModel transConfigModel;
  private List<SourceConfigModel> sourceConfigModelList;
  private List<MappingConfigModel> mappingConfigModelList;

}
