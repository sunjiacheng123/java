package com.sun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonDao extends BaseMapper<Person> {
}
