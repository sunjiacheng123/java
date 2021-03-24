package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserDao {
    List<User> findAll();//查询全部

    int insertUser(User user);//插入用户

    User findId(Integer id);//根据nameid查询

    void deleteId(Integer id);//根据nameid删除

    void updateUser(User user);//更新用户

    void insertUserListByList(List<Map<String,Object>> list);

    List<User> selectByArray(Integer[] id);

    List<User> selectByList(List<Integer> users);

    List<User> selectByMap(Map<String, List<Integer>> map);
}
