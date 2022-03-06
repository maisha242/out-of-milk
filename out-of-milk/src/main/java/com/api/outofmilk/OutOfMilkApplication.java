package com.api.outofmilk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class OutOfMilkApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutOfMilkApplication.class, args);
    }

}
