package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication/*开启入口类*/
@MapperScan("com.jk.dao")/*扫描持久层*/
@EnableTransactionManagement/*开启注解*/
public class TextdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextdemoApplication.class, args);
    }

}
