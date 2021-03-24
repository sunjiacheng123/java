package com.sun.study.service;


import com.sun.study.dao.UserDao;
import com.sun.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;


    public List<User> selectList(Object o) {
        return userDao.selectList(null);
    }

    public User selectId(int id) {
        return userDao.selectById(id);
    }
}