package cn.hncu.hello;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.hncu.domain.Person;
import cn.hncu.util.MyBatisUtil;

public class Hello {
	/* 实现映射：
	 * 1) 按规范的话，需要写一个POJO的映射文件，命名规范：类名Mapper.xml；位置与POJO同一个包下。
	 * 2) 在类名Mapper.xml中必须给 mapper标签的namespace属性赋值，即使值没有任何意义。
	 * 3) 在mybatis-config.xml中进行关联
	 * 		如： 
	   			<mappers>
					<!-- 使用相对于类路径的资源引用 -->
					<mapper resource="cn/hncu/domain/PersonMapper.xml" />
				</mappers>
	 */
	public static void main(String[] args) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//List<Person> list = sqlSession.selectList("all"); //当不存在冲突时，可以省略命名空间的前缀
		List<Person> list = sqlSession.selectList("p.all"); //当存在冲突时，必须使用命名空间的前缀
		for (Person person : list) {
			System.out.println(person);
		}
	}
}
