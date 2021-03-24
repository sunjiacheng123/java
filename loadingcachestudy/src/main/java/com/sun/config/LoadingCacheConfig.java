package com.sun.config;

import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;
import com.sun.controller.PersonController;
import com.sun.domain.Person;
import com.sun.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class LoadingCacheConfig {
    private static final Logger logger = LoggerFactory.getLogger(LoadingCacheConfig.class);

    @Autowired
    private PersonService personService;

    @Bean("stringCache")
    // LoadingCache<String{userId[account]}, UserInfo{id,name,age,MD5Password,...}>
    public LoadingCache<String, String> stringCache() {
        return CacheBuilder.newBuilder().maximumSize(200)//即将到达指定的大小，那就会把不常用的键值对从cache中移除。
                .expireAfterAccess(10, TimeUnit.SECONDS)//即将到达指定的大小，那就会把不常用的键值对从cache中移除。
                .expireAfterWrite(10, TimeUnit.SECONDS)//根据某个键值对被创建或值被替换后多少时间移除
                .removalListener(new RemovalListener<String, String>() {//移除后的操作
                    @Override
                    public void onRemoval(RemovalNotification<String, String> removalNotification) {
                        System.out.println("移除后的操作");
                        String str = String.format("key=%s,value=%s", removalNotification.getKey(), removalNotification.getValue());
                        System.out.println(str);
                    }
                })
                //开启统计功能
                .recordStats()
                //取缔办法自动加载
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String account) throws Exception {
                        logger.info("缓存中不存在，将数据载入缓存中..............");

                        return account+'1';
                    }

                });
    }

    @Bean("loadingCachePerson")
    public LoadingCache<String, Person> loadingCachePerson() {
        return CacheBuilder.newBuilder().maximumSize(200)//即将到达指定的大小，那就会把不常用的键值对从cache中移除。
                .expireAfterAccess(10, TimeUnit.SECONDS)//即将到达指定的大小，那就会把不常用的键值对从cache中移除。
                .expireAfterWrite(10, TimeUnit.SECONDS)//根据某个键值对被创建或值被替换后多少时间移除
                .removalListener(new RemovalListener<String, Person>() {//移除后的操作
                    @Override
                    public void onRemoval(RemovalNotification<String, Person> removalNotification) {
                        System.out.println("移除后的操作");
                        String str = String.format("key=%s,value=%s", removalNotification.getKey(), removalNotification.getValue());
                        System.out.println(str);
                    }
                })
                //开启统计功能
                .recordStats()
                //取缔办法自动加载
                .build(new CacheLoader<String, Person>() {
                    @Override
                    public Person load(String account) throws Exception {
                        logger.info("缓存中不存在，将数据载入缓存中..............");

                        // load form db
                        return personService.getById(account);
                    }
                });
    }
}
