package com.thoughtworks.demo.oauth.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created by hwwei on 2017/2/23.
 */
@SpringBootApplication
@EnableGlobalMethodSecurity
@EnableOAuth2Sso
@EnableOAuth2Client
public class GithubApplication extends WebSecurityConfigurerAdapter{
    public static void main(String[] args) {
        SpringApplication.run(GithubApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/*").authenticated().anyRequest().permitAll();
    }
}
