package com.sun.controller;

import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import com.sun.domain.Person;
import com.sun.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@Controller
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    private Map<String, Person> authCahce = Maps.newHashMap();

    @Autowired
    @Qualifier("stringCache")
    private LoadingCache<String, String> loadingCache;

    @Autowired
    @Qualifier("loadingCachePerson")
    private LoadingCache<String, Person> loadingCachePerson;

    @ResponseBody
    @RequestMapping("login")
    public String login(@RequestParam("account") String account, @RequestParam("pwd") String pwd) {
        // {retCode: 0,-1,  retData: "{personJSON}" }
        try {
            Person person = authCahce.get(account);
            if(person != null) {
                // 验证密码
                // return Codec.md5(pwd) == person.getMd5Pwd ? loginSucs : loginFail
            }

            Person personInDb = personService.getById(account);
            if(personInDb == null) {
                return "loginFail";
            }

            // 验证密码
            // return Codec.md5(pwd) == person.getMd5Pwd ? loginSucs : loginFail
            authCahce.put(account, personInDb);
        } catch (Exception e) {
            logger.error("查询缓存出错", e);
        }

        return "success";
    }



    @ResponseBody
    @RequestMapping("login1")
    public String login1(@RequestParam("nameId") String nameId, @RequestParam("passWord") String passWord) {
        logger.info("按照id查询");
        //先看缓存中有没有，没有就加入缓存，
        try {
            Person person = loadingCachePerson.get(nameId);
            if(person != null) {
                // 验证密码
                // return Codec.md5(pwd) == person.getMd5Pwd ? loginSucs : loginFail
            }

        } catch (ExecutionException e) {
            logger.error("查询缓存出错", e);
        }

        return "success";
    }

    @ResponseBody
    @RequestMapping("sign")
    public String sign(@RequestParam("nameId") String nameId, @RequestParam("passWord") String passWord) {
        logger.info("按照id查询");

        try {
            String pwd = loadingCache.get(nameId);
            logger.info("加载完成");
            if(pwd != null && !"".equals(pwd)) {
                if(pwd.equals(passWord)) {
                    return "success";
                }
            }

        } catch (ExecutionException e) {
            logger.error("查询缓存出错", e);
        }

        return "success";
    }

}
