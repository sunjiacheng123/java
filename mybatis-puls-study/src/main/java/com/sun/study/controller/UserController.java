package com.sun.study.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.sun.study.dao.UserDao;
import com.sun.study.domain.User;
import com.sun.study.service.UserMybatisPlusSerivce;
import com.sun.study.service.UserService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

@Controller
public class UserController {
    private static final Logger LOGGER= LogManager.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMybatisPlusSerivce userMybatisPlusSerivce;

    @RequestMapping("selectall")
    @ResponseBody
    public List<User> selectAll(){
        List<User> ls= userService.selectList(null);
        return ls;
    }

    @ResponseBody
    @RequestMapping("selectId/{id}")
    public User selectId(@PathVariable Integer id){
        User user=userService.selectId(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("selectById/{id}")
    public User selectById(@PathVariable Integer id){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, id);

        User u = new User();
        userMybatisPlusSerivce.save(u);

        return userMybatisPlusSerivce.getOne(queryWrapper);
    }

    @ResponseBody
    @RequestMapping("demo")
    public String demo(User user, @RequestParam("ggg") String sd){
        System.out.println(sd);
        return user.toString();
    }

}
