package com.reggie.snow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * show 方法的简述.
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class SnowWebApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SnowWebApplication.class, args); }
}
