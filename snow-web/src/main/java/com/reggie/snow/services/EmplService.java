package com.reggie.snow.services;

import com.reggie.snow.daos.EmplDao;
import com.reggie.snow.daos.entity.Empl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by didi on 17/4/14.
 */
@Service
@Slf4j
public class EmplService {

    @Autowired
    private EmplDao emplDao;

    public Empl findByID(String emplID) {
        return emplDao.findByID(emplID);
    }
}
