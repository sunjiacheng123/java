package com.sun.study.domain;

import lombok.Data;

@Data
public class User {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private String name;
    private int id;
    private int age;
    private String sex;


    public static void main(String[] args) {
        String age = "age";

        threadLocal.set(age);
        action1("zhangsan");
        threadLocal.remove();
    }

    public static void action1(String name) {
        action2(name);
    }


    public static void action2(String name) {
        action3(name);

       // dao.select();
    }

    public static void action3(String name) {
        System.out.println("name: " + name);
        String age = threadLocal.get();
        System.out.println("name: " + age);
    }


}
