package com.sun.study.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.sun.study.domain.User;
import com.sun.study.service.UserMybatisPlusSerivce;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserMybatisPlusSerivce userMybatisPlusSerivce;

    @ResponseBody
    @RequestMapping("insertAndUpdate")
    public String insertAndUpdate(@RequestBody User[] user) {
        LOGGER.info("插入和更新数据---------");
        userMybatisPlusSerivce.insertAndUpdate(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping("selectById/{id}")
    public User selectById(@PathVariable Integer id) {
        LOGGER.info("根据id查询与用户");
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, id);
        return userMybatisPlusSerivce.getOne(queryWrapper);
    }

    @ResponseBody
    @RequestMapping("countByAge/{age}")
    public int countByAge(@PathVariable Integer age) {
        LOGGER.info("查询年龄大于等于" + age + "的人数");
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(User::getAge, age);
        return userMybatisPlusSerivce.count(queryWrapper);
    }

    @ResponseBody
    @RequestMapping("saveBatch")
    public String saveBatch(@RequestBody List<User> userList) {
        LOGGER.info("批量插入用户---------");
        userMybatisPlusSerivce.saveBatch(userList);
        return "success";
    }

    @ResponseBody
    @RequestMapping("selectByPage/{pageNum}/{pageSize}")
    public List<User> selectByPage(@PathVariable(value = "pageNum") Integer pageNum, @PathVariable(value = "pageSize") Integer pageSize) {
        LOGGER.info("使用分页插件PageHelper，进行分页");
        PageHelper helper = new PageHelper();
        helper.startPage(pageNum, pageSize);
        return userMybatisPlusSerivce.list();
    }

    //    @ResponseBody
//    @RequestMapping("selectBypulsPage/{pageNum}/{pageSize}")
//    public List<User> selectBypulsPage(@PathVariable(value = "pageNum") int num, @PathVariable int pageSize){
//        LOGGER.info("使用mybatis-puls的进行分页");
//        return userMybatisPlusSerivce.selectBypulsPage(num,pageSize);
//    }
    @ResponseBody
    @RequestMapping("selectBypulsPage/{pageNum}/{pageSize}")
    public List<User> selectBypulsPage(@PathVariable(value = "pageNum") Integer pageNum, @PathVariable(value = "pageSize") Integer pageSize) {
        LOGGER.info("使用mybatis-puls的进行分页");
        IPage<User> page = new Page<>(pageNum, pageSize);
        page = userMybatisPlusSerivce.page(page);
        List<User> users = page.getRecords();
        return users;
    }

}
