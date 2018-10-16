package cn.hncu.hello;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.hncu.domain.User;
import cn.hncu.domain.UserMapper;
import cn.hncu.domain.UserQueryModel;
import cn.hncu.util.MyBatisUtil;

/* 使用 User 进行演示 CURD
 */
public class Demo {
	
	/* 采用接口开发的好处：可以避免直接通过[namespace.]id去定位select标签， 假设不知道结果类型时，
	 * 				  可能造成类型强转异常。使用面向接口就不会出现这种情况，因为接口可以限定了返回类型。
	 */
	//无条件查询
	@Test
	public void all() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		List<User> users = userMapper.all();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	//单条件查询
	@Test 
	public void query1() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		User user = userMapper.query1(1);
		System.out.println( user );
	}
	
	//多条件查询
	@Test 
	public void query2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		User user = new User();
		user.setId(1);
		/*
		 select * from user where id=#{id} or name LIKE '%${name}%'
		 user.setName("j%' or 1=1 or name ='");  //BUG
		 select * from user where id=#{id} or name LIKE "%${name}%"
		 user.setName("j%\" or 1=1 or name =\"");  //BUG
		 */
		user.setName("j%\" or 1=1 or name =\""); 
		//user.setName("j");
		List<User> users = userMapper.query2(user);
		
		for (User u : users) {
			System.out.println(u);
		}
	}
	//使用查询值对象
	@Test
	public void query3() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		UserQueryModel uqm = new UserQueryModel();
		uqm.setId(1);
		uqm.setAge(20);
		uqm.setAge2(22);
		List<User> users = userMapper.query3(uqm);
		for (User u : users) {
			System.out.println(u);
		}
	}
	//使用map
	@Test
	public void query4() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("age", 20);
		map.put("age2", 22);
		List<User> users = userMapper.query4(map);
		for (User u : users) {
			System.out.println(u);
		}
	}
	
	/////////下面演示增删改查/////////
	/* 注意：增删改都必须commit,因为mybatis默认是开启事务的也就是setAutoCommit(false);
	 */
	//增
	@Test
	public void add() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		User user = new User();
		user.setName("刘备");
		user.setAge(19);
		userMapper.add(user);
		//注意：增删改都必须commit
		sqlSession.commit(); //提交事务
		all(); //调用查询所有
	}
	//删
	@Test
	public void del() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		userMapper.del(3);
		
		sqlSession.commit(); //提交事务
		all(); //调用查询所有
	}
	//改
	@Test
	public void update() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		User user = new User();
		user.setName("老干妈");
		user.setAge(18);
		user.setId(4);
		userMapper.update(user);
		//注意：增删改都必须commit
		sqlSession.commit(); //提交事务
		all(); //调用查询所有
	}
	///演示sql标签使用///
	@Test
	public void sqlDemo() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		List<User> users = userMapper.sqlDemo();
		for (User u : users) {
			System.out.println(u);
		}
	}
	//演示获取自动增长id---值对象封装
	@Test
	public void autoKeys() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		User user = new User();
		user.setName("马化腾");
		user.setAge(38);
		userMapper.autoKeys(user);
		System.out.println(user);//User [id=7, name=马化腾, age=38]
		sqlSession.commit();
	}
	//演示获取自动增长id--map封装
	@Test
	public void autoKeys2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Rose");
		map.put("age", 16);
		userMapper.autoKeys2(map);
		//自动增长id封装在map中，并且key为keyProperty的值即 'iid'
		System.out.println(map); //{iid=8, name=Rose, age=16}
		sqlSession.commit();
	}
}
