package cn.hncu.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		
		String resource = "mybatis-config.xml";
		
		/* //底层方式
		InputStream in = MybatisUtil.class.getClassLoader().getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		*/
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder()
									.build( Resources.getResourceAsStream(resource));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取 mybatis-SqlSessionFactory实例
	 * @return SqlSessionFactory实例
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	/**
	 * 获取 SqlSession实例
	 * @return SqlSession实例
	 */
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
