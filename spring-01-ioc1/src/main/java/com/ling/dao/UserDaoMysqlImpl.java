package com.ling.dao;

public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("MYSQL取用户");
    }
}
