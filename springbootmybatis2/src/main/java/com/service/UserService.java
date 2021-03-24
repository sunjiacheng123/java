package com.service;

import com.dao.UserDao;
import com.domain.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {



    @Autowired
    UserDao userDao;

    public List<User> findAll(){
        List<User> list=userDao.findAll();
        return list;
    }

    public void delete(int d) {
        userDao.deleteId(d);
    }

    public User findId(int id) {
        return userDao.findId(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
