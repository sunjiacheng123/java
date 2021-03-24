package com.sqlsession;

import com.Dao.UserDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
@Mapper
@Repository
public class CrreateSqlSession {
    private InputStream is;
    private SqlSession sqlSession;
    private UserDao userDao;
    private Logger logger;


    public CrreateSqlSession(){
        try {
            is= Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
            sqlSession=ssf.openSession();
            userDao=sqlSession.getMapper(UserDao.class);
            logger= LoggerFactory.getLogger(CrreateSqlSession.class);
            logger.info("建立连接--------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
