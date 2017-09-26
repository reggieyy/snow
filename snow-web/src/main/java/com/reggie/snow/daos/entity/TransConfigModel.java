package com.reggie.snow.daos.entity;

import com.reggie.snow.util.annotations.UUIDGenerator;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

/**
 *
 * 核心配置表
 * @date 2017.7.26
 * @author qingtian
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransConfigModel implements Serializable {

  private static final long serialVersionUID = 7051200220980751757L;

//  @Id
//  @GenericGenerator(name="systemUUID",strategy="uuid")
//  @GeneratedValue(generator="systemUUID")
  private String transID;

  private String transName;
  private String transDesc;
  private String sourceConfigID;
  private String targetConfigID;
  private String sourceTargetSql;
  private String mappingConfig;
  private Integer isValid;
  private Integer isEnable;
  private Integer type;

  private String sourceTable;
  private String targetTable;

}
