package com;

import com.dao.UserDao;
import com.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
//@MapperScan("r")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootTest
class SpringbootmybatisApplicationTests {
//	@Autowired
//	private UserService userService;

	private InputStream is;
	private SqlSession sqlSession;
	private UserDao userDao;
	private Logger logger;
	//测试前建立连接
	@BeforeEach
	void init(){
		try {
			is= Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
			sqlSession=ssf.openSession();
			userDao=sqlSession.getMapper(UserDao.class);
			logger= LoggerFactory.getLogger(SpringbootmybatisApplicationTests.class);
			logger.info("建立连接--------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//测试完  关闭连接
	@AfterEach
	void close(){
		sqlSession.commit();
		sqlSession.close();
		logger.info("关闭连接---------------------------------");
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFindall() {
		//userService.findall();
		List<User> users=userDao.findAll();
		logger.info("查询所有用户----------------------------");
		for (User user : users){
			System.out.println(user.toString());
		}
	}

	@Test
	void testUpdateUser(){
		logger.info("更新用户--------------------------");
		User user=new User();
		user.setAge(12);
		user.setId(1);
		user.setSex("nan");
		user.setName("小明");
		userDao.updateUser(user);
	}

	@Test
	void testInsertUser(){
		logger.info("插入用户----------------------");
		User user=new User();
		user.setAge(23);
		user.setId(65);
		user.setSex("nv");
		user.setName("老王");
		int id=userDao.insertUser(user);
		System.out.println(id);
	}

	@Test
	void testFindId(){
		logger.info("根据id从查询用户---------------");
		User user=userDao.findId(2);
		System.out.println(user.toString());
	}

	@Test
	void testDeletId(){
		logger.info("删除用户id为99的----------------");
		userDao.deleteId(99);
	}

	@Test
	void testPageSelect(){
		logger.info("分页查询---------------------------");
		PageHelper.startPage(2,5);

		List<User> users=userDao.findAll();
		PageInfo<User> pageInfo=new PageInfo<>(users);
		System.out.println(pageInfo);

	}


}
