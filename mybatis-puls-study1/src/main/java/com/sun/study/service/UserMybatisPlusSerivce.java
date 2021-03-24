package com.sun.study.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.study.dao.UserDao;
import com.sun.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserMybatisPlusSerivce extends ServiceImpl<UserDao, User> {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertAndUpdate(User[] user) {
        userDao.insert(user[0]);
        System.out.println("插入成功-------------");
        //int i=1/0;
        userDao.updateById(user[1]);
    }

    //异常被处理了，事务不会进行回滚
    @Transactional
    public void insertAndUpdate1(User[] user) {
        try {
            userDao.insert(user[0]);
            System.out.println("插入成功-------------");
            int i=1/0;
            userDao.updateById(user[1]);
        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }

    public List<User> selectBypulsPage(int num, int pageSize) {
        IPage<User> page=new Page<>(num,pageSize);
        page=userDao.selectPage(page,null);
        List<User> list=page.getRecords();
        return list;
    }
}
