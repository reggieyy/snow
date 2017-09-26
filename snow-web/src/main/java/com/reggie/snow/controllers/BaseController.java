package com.reggie.snow.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * Created by reggie on 2017/8/28.
 */
public class BaseController {

  HttpHeaders headers = new HttpHeaders();

  public BaseController(){

    headers.setContentType(MediaType.APPLICATION_JSON);
  }

}
