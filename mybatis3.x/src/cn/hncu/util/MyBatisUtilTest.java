package cn.hncu.util;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisUtilTest {
	
	//测试是否能够初始化
	@Test
	public void hello() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		System.out.println(sqlSession);
	}
	
	//测试连续拿10个 SqlSession 是什么情况
	@Test
	public void t1() {
		/* 测试发现：SqlSession与Hibernate中的Session不同，
		 * 一个SqlSession对应最多一个Connection，
		 * 当SqlSession没有调用getConnection()方法时，
		 * SqlSession是不含有Connection的，只有调用了才有，所以不会出现程序卡住现象。
		 */
		for (int i = 0; i < 10; i++) {
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			System.out.println(sqlSession);
		}
	}
	
	//测试获取sqlSession并且获取Connection
	@Test
	public void t2() {
		/* 测试发现：由于在配置文件中设置了 poolMaximumActiveConnections值为5
		 * 所以 Connection 最多只有5个，当i==5的时候程序会卡住30~40秒，因为期间没有Connection可供使用。
		 * 为什么是卡住30~40秒？因为设置了 poolMaximumCheckoutTime参数为 30000(30秒)
		 * 之所以会是30~40是因为检查连接至少30秒没被使用才会回收。如果没配置默认 20000。
		 * 同时可以发现，每个SqlSession都是不同的，但是Connection只有5个。
		 */
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			Connection connection = sqlSession.getConnection();
			System.out.println("sqlSession:"+sqlSession.hashCode());
			System.out.println("connection:"+connection.hashCode());
			System.out.println("-----------");
		}
		long end = System.currentTimeMillis();
		System.out.println( end-start );
	}
}
