package com.Dao;

import com.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> findAll();//查询全部

    int insertUser(User user);//插入用户

    User findId(Integer id);//根据nameid查询

    void deleteId(Integer id);//根据nameid删除

    void updateUser(User user);//更新用户

}
