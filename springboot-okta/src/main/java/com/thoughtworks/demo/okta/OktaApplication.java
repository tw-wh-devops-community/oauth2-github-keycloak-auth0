package com.thoughtworks.demo.okta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by hwwei on 2017/3/6.
 */
@SpringBootApplication/*(exclude = {SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class})*/
@ImportResource("classpath:/security/securityContext.xml")
public class OktaApplication {
    public static void main(String[] args) {
        SpringApplication.run(OktaApplication.class, args);
    }
}
