package com.sun.study.lamda;

import com.sun.study.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");


        for(String s : lists) {
            System.out.println(s);
        }

        lists.forEach(s -> {
            System.out.println(s);
        });

        List<User> userList = new ArrayList<>();
        userList.add(new User());

        List<Integer> userIdList = userList.stream().map(User::getId).collect(Collectors.toList());
        userIdList = userList.stream().map(user -> {
            return user.getId();
        }).collect(Collectors.toList());

        Map<String, String> maps = new HashMap<>();
        maps.put("1", "1");
        maps.put("2", "2");

        for(Map.Entry<String, String> entry : maps.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        maps.forEach((key, val) -> System.out.println(key + ", " + val));


    }
}
