package com.controller;

import com.domain.User;
import com.github.pagehelper.PageHelper;
import com.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    //private static Logger logger;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("selectall")
    List<User> findAll() {
        logger.info("查询所有----------------");
        List<User> list = userService.findAll();
        return list;
    }

    @ResponseBody
    @RequestMapping("deleteId/{d}")
    String delets(@PathVariable int d) {
        logger.info("根据id删除用户-------------------");
        userService.delete(d);
        return "success";
    }

    @ResponseBody
    @RequestMapping("findId/{id}")
    User findId(@PathVariable int id) {
        User user = userService.findId(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("user")
    String user(@RequestBody User[] u){
        logger.info("测试-------------------");
        System.out.println(u[0]);
        System.out.println(u[1]);
        return "success";
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
    String updateUser(@RequestBody User user) {
        logger.info("更新用户---------------");
        userService.updateUser(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping("insertuser")
    String insertUser(@RequestBody User user) {
        logger.info("插入用户-----------------------");
        userService.insertUser(user);
        return "success";
    }


    @ResponseBody
    @RequestMapping("pagefind/{pagenum}/{pagesize}")
    List<User> pagefind(@PathVariable("pagenum") int pageNum, @PathVariable("pagesize") int pageSize) {
        //pageNum:设置查询页
        //pageSize：每页的容量
        PageHelper.startPage(pageNum, pageSize);
        logger.info("分页查询:第" + pageNum + "页       " + "每页有" + pageSize + "条");
        return userService.findAll();
    }

//
//    @RequestMapping("test")
//    public String test(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

    //没有RequestBody的话，底层实现可以通过
    // content-Type: text
    // url?name=a&age=0
    // request.getParameter("name");

    // url/pageFind/1/2
    // request.getRequestURL()

    // content-Type: Json
/*
没有RequestBody的话，底层实现可以通过request.getHeader得到contentType，判断contentType时text还是json，
如果是text的话，就可以使用getParameter获取url中的字符串，
如果是json的话，可以使用request.getInputStream().read()读入到byte数组，再用string表现出来
 */
//        String contentType = request.getHeader("contentType");
//        if(contentType.equals("text/plain")) {
//            request.getParameter("");
//
//        } else if (contentType.equals("json/application")) {
//            byte[] data = new byte[1024];
//            request.getInputStream().read(data);
//
//            // {"name":"zhangsan".....}
//            String s = new String(data, "utf-8");
//
//        } else if ("file")
/*
使用ResponseBody，相当于将返回数据转成了json格式
没有ResponseBody的话就使用response.getOutputStream().write
 */
//        // ResponseBody
//        response.getOutputStream().write(JSON(byte[] a) -> byte[]);
//
//        Gson gson = new Gson();
//        String resp = gson.toJson(new Object());

    // File file apened write(String )
    // service.doAction1();
    // selfLog.info() , -> file.   new Thread();  -> Excetuor(ThreadPool)
    // service.doAction2();

    // bizLog-2010-02-02.log
    // bizLog-2010-02-03.log
    // bizLog-2010-02-03-1.log (100MB)
    // bizLog-2010-02-03-2.log

    // log4j2
    // log4j2.xml

    // controller.log
    // service.log
    // dao.log
    // serv1.log
    // serv2.log
//
//
//        return resp;
//    }

    @ResponseBody
    @RequestMapping("insertUserListByList")
    public String insertUserListByList(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","66");
        map.put("sex","nan");
        map.put("id",660);
        map.put("age",66);
        List<Map<String,Object>> ls=new ArrayList<>();
        ls.add(map);
        userService.insertUserListByList(ls);
        return "success";
    }

    @ResponseBody
    @RequestMapping("selectByArray")
    public List<User> selectByArray(@RequestParam("id") Integer[] id){
        logger.info("搜索数组");
        List<User> users=userService.selectByArray(id);
        return users;
    }

    @ResponseBody
    @RequestMapping("selectByList")
    public List<User> selectByList(@RequestParam("id") List<Integer> id){
        logger.info("插入list数组");
        return userService.selectByList(id);
    }

    @ResponseBody
    @RequestMapping("selectByMap")
    public List<User> selectByMap(){
        logger.info("查询map集合");
        Map<String,List<Integer>> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        map.put("id",list);

        return userService.selectByMap(map);
    }
}
















