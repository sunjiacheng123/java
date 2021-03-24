package com.controller;

import com.domain.User;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    Logger logger= LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("selectall")
    List<User> findAll(){
        logger.info("查询所有----------------");
        List<User> list=userService.findAll();
        return list;
    }
}
