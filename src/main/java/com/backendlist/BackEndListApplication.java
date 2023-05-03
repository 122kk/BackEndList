package com.backendlist;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 启动类
 */
@SpringBootApplication
@Slf4j
@MapperScan("com.backendlist.RedisSeckill.mapper")
public class BackEndListApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndListApplication.class, args);
        log.info("BackendListApplication启动成功!!!");
    }

}
