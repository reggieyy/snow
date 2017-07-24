package com.reggie.snow.daos.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by didi on 17/4/14.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Empl implements Serializable {

    private static final long serialVersionUID = 7582172933185291507L;

    private String emplID;
    private String emplName;
}
