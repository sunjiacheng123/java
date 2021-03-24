package com.sun.study.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.study.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao extends BaseMapper<User> {

}
