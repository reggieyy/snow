package com.reggie.snow.daos.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by reggie on 2017/7/24.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransConfigModel implements Serializable {

  private static final long serialVersionUID = 7051200220980751757L;

  private String transID;
  private String transName;
  private String transDesc;
  private String sourceConfig;
  private String targetConfig;
  private String mappingConfig;
  private Integer isValid;
  private Integer isEnable;
  private Integer type;

}
