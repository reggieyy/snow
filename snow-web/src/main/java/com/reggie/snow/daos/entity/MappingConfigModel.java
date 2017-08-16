package com.reggie.snow.daos.entity;

import java.io.Serializable;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by reggie on 2017/7/26.
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MappingConfigModel implements Serializable,Comparable<MappingConfigModel> {

  private static final long serialVersionUID = 2229703276977629486L;

  private String transID;
  private String fromField;
  private String fromFieldName;
  private String toField;
  private String toFieldName;

  @Override
  public int compareTo(MappingConfigModel mappingConfigModel) {
    if(fromField.hashCode() > mappingConfigModel.getFromField().hashCode()){
      return 1;
    }
    return 0;
  }
}
