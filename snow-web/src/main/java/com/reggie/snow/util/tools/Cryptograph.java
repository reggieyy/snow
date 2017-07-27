package com.reggie.snow.util.tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 *
 * 加密解密工具类
 * @date 2017.7.27
 * @author qingtian
 *
 */
public class Cryptograph {


  public static void main(String[] args)
      throws NoSuchAlgorithmException, UnsupportedEncodingException {
    MessageDigest md5=MessageDigest.getInstance("MD5");
    BASE64Encoder base64en = new BASE64Encoder();
    //加密后的字符串
    String newstr=base64en.encode(md5.digest("qingtian".getBytes("utf-8")));
    System.out.print(newstr);
  }
}
