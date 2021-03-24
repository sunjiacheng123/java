package com.sun.springbootdemo.studydemo.controller;

import com.sun.springbootdemo.studydemo.entity.Person;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

//    @Autowired
//    Persion persion;

    // log4j, logback


    @RequestMapping("hello" )
    public String getByJson(@RequestBody Person person){
        System.out.println(person);

        return person.toString();
    }

    @RequestMapping("request")
    public void jsonToObject(HttpServletRequest request){
        String str =request.getParameter("str");
        System.out.println(str);
        JSONObject jsonObject=JSONObject.fromObject(str);
        Person p= (Person) JSONObject.toBean(jsonObject);
        System.out.println(p.toString());
    }

}
