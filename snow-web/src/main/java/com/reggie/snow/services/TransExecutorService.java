package com.reggie.snow.services;

import com.reggie.snow.daos.TransConfigDao;
import com.reggie.snow.daos.entity.TransConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 转数执行器
 * @date 2017.07.26
 * @author qingtian
 *
 */
@Service
public class TransExecutorService {

  @Autowired
  private TransConfigDao transConfigDao;

  /**
   * 执行器
   * 1.根据transID获取转数配置
   * 2.是否已经存在连接池，如存在直接调用，如不存在则新建连接池再调用
   * 3.事务不适用autoCommit，通过getConnection自主进行事务提交
   * @param transID
   */
  public void execute(String transID){
    TransConfigModel transConfigModel = transConfigDao.findTransConfigByID(transID);

  }
}
