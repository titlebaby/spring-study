package com.ling.service;

import com.ling.dao.UserDao;
import com.ling.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private  UserDao userDao = new UserDaoImpl();

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
