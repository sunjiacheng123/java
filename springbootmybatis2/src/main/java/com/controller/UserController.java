package com.controller;

import com.domain.User;
import com.github.pagehelper.PageHelper;

import com.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.logging.LogManager;

@Controller
public class UserController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;


    @ResponseBody
    @RequestMapping("selectall")
    List<User> findAll(){
        logger.info("查询所有----------------");
        List<User> list=userService.findAll();
        return list;
    }

    @ResponseBody
    @RequestMapping("deleteId/{d}")
    String delets(@PathVariable int d){
        logger.info("根据id删除用户-------------------");
        userService.delete(d);
        return "success";
    }

    @ResponseBody
    @RequestMapping("findId/{id}")
    String findId(@PathVariable int id){
        User user=userService.findId(id);
        return user.toString();
    }

//    @ResponseBody
//    @RequestMapping("update")
//    String updateUser(HttpServletRequest request){
//        logger.info("更新用户---------------");
//        String str=request.getParameter("str");
//        Gson gson=new Gson();
//        User user=gson.fromJson(str,User.class);
//        userService.updateUser(user);
//        return "success";
//    }
    @ResponseBody
    @RequestMapping("update")
    String updateUser(@RequestBody User user){
        logger.info("更新用户---------------");
        userService.updateUser(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping("insertuser")
    String insertUser(@RequestBody User user){
        logger.info("插入用户-----------------------");
        userService.insertUser(user);
        return "success";
    }


    @ResponseBody
    @RequestMapping("pagefind/{pagenum}/{pagesize}")
    List<User> pagefind(@PathVariable("pagenum") int pageNum , @PathVariable("pagesize") int pageSize){
        //pageNum:设置查询页
        //pageSize：每页的容量
        PageHelper.startPage(pageNum,pageSize);
        logger.info("分页查询:第"+pageNum+"页       "+"每页有"+pageSize+"条");
        return userService.findAll();
    }
}
