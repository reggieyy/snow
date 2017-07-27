package com.reggie.snow.daos.entity;

import java.io.Serializable;
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
public class MappingConfigModel implements Serializable {

  private static final long serialVersionUID = 2229703276977629486L;

  private String fromFields;
  private String toFields;
  private String fromTable;
  private String toTable;

}
