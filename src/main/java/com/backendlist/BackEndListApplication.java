package com.backendlist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BackEndListApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndListApplication.class, args);
        log.info("BackendListApplication启动成功!!!");
    }

}
