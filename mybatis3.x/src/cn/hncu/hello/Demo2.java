package cn.hncu.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.hncu.domain.User;
import cn.hncu.domain.UserMapper2;
import cn.hncu.util.MyBatisUtil;

public class Demo2 {
	
	//当没有 id时会出现以下BUG
	//select * from user where 1=1 or name like "%"?"%" or age > ?    BUG
	@Test
	public void dynamicQuery1() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper2 mapper = sqlSession.getMapper( UserMapper2.class );
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("id", 1);
		map.put("name", "j");
		map.put("age", 18);
		List<User> users = mapper.dynamicQuery1(map);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	//select * from user WHERE name like "%"?"%" or age > ?   
	//使用where标签会自动去掉多余的 or/and
	@Test
	public void dynamicQuery2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper2 mapper = sqlSession.getMapper( UserMapper2.class );
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("id", 1);
		map.put("name", "j");
		map.put("age", 18);
		List<User> users = mapper.dynamicQuery2(map);
		for (User user : users) {
			System.out.println(user);
		}
	}
	//使用trim标签
	@Test
	public void dynamicQuery3() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper2 mapper = sqlSession.getMapper( UserMapper2.class );
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("id", 1);
		map.put("name", "j");
		map.put("age", 18);
		List<User> users = mapper.dynamicQuery2(map);
		for (User user : users) {
			System.out.println(user);
		}
	}
	//使用set标签
	@Test
	public void dynamicUpdate() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper2 mapper = sqlSession.getMapper( UserMapper2.class );
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 2);
//		map.put("name", "张飞");
//		map.put("age", 33);
		mapper.dynamicUpdate(map);
		//一定要提交事务
		sqlSession.commit();
	}
	//使用 foreach标签
	@Test
	public void inQuery() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper2 mapper = sqlSession.getMapper( UserMapper2.class );
		List<Integer> ids = new ArrayList<Integer>();
		ids = Arrays.asList(1,5,10,6,30);
		List<User> users = mapper.inQuery(ids);
		for (User user : users) {
			System.out.println(user);
		}
	}
}
