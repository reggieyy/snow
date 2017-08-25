package com.reggie.snow.daos.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by reggie on 2017/8/23.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupConfigModel implements Serializable {

  private static final long serialVersionUID = -5358790292338343655L;

  private String groupID;
  private String groupName;
  private String groupDesc;
  private Integer isValid;
}
