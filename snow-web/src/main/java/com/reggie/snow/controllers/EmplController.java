package com.reggie.snow.controllers;

import com.alibaba.fastjson.JSONObject;
import com.reggie.snow.daos.entity.Empl;
import com.reggie.snow.services.EmplService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by didi on 17/4/14.
 */
@RestController
@RequestMapping("/empl")
@Slf4j
public class EmplController {

    @Autowired
    private EmplService emplService;

    @RequestMapping(value = "/getEmpl", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> findEmpls(@RequestBody Empl empl) {
        JSONObject object = new JSONObject();
        try {
            Empl result = emplService.findByID(empl.getEmplID());
            object.put("empl", result);
            return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
        } catch (Exception e) {
            log.error("查询人员信息异常{}", e);
            object.put("empl", "null");
            return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
        }
    }

}
