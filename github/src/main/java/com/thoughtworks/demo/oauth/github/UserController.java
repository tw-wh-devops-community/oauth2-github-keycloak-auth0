package com.thoughtworks.demo.oauth.github;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hwwei on 2017/2/23.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping
    public Authentication getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication;
    }
}
