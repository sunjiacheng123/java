package com.service;

import com.dao.UserDao;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> findAll(){
        List<User> list=userDao.findAll();
        return list;
    }

    public void delete(int d) {
        userDao.deleteId(d);
    }

    public User findId(int id) {
        return userDao.findId(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public void insertUserListByList(List<Map<String, Object>> ls) {
        userDao.insertUserListByList(ls);
    }

    public List<User> selectByArray(Integer[] id) {
        return userDao.selectByArray(id);

    }

    public List<User> selectByList(List<Integer> users) {

        return userDao.selectByList(users);
    }

    public List<User> selectByMap(Map<String, List<Integer>> map) {
        return userDao.selectByMap(map);
    }
}
