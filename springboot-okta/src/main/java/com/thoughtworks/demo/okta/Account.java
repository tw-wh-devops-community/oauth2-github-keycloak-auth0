package com.thoughtworks.demo.okta;

/**
 * Created by hwwei on 2017/3/7.
 */
public class Account {
    private final String name;
    private final boolean isAdmin;

    public Account(String name, boolean isAdmin) {
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getName() {
        return name;
    }

}
