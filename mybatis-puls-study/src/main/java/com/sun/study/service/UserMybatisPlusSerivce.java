package com.sun.study.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.study.dao.UserDao;
import com.sun.study.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserMybatisPlusSerivce extends ServiceImpl<UserDao, User> {
}
