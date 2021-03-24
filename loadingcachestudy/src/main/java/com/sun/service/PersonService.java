package com.sun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.dao.PersonDao;
import com.sun.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends ServiceImpl<PersonDao, Person> {

}
