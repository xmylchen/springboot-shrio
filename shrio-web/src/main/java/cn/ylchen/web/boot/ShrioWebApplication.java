package cn.ylchen.web.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cn.ylchen")
public class ShrioWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShrioWebApplication.class, args);
    }

}

