package com.service;

import com.Dao.UserDao;
import com.domain.User;
import com.sqlsession.CrreateSqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {



    @Autowired
    CrreateSqlSession css;

    public List<User> findAll(){
        return css.getUserDao().findAll();
    }
}
