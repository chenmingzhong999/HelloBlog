package net.evercodig.helloblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.evercodig.helloblog.dao")
public class HelloBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloBlogApplication.class,args);
    }
}
