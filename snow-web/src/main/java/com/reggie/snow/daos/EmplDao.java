package com.reggie.snow.daos;

import com.reggie.snow.daos.entity.Empl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * test
 */
@Mapper
public interface EmplDao {

    String SELECT_BY_ID = "select emplid,emplname from empl where emplid = #{emplID}";
    @Select(SELECT_BY_ID)
    Empl findByID(String emplID);

}
