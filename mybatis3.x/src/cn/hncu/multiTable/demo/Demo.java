package cn.hncu.multiTable.demo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.hncu.multiTable.domain.Book;
import cn.hncu.multiTable.domain.BookMapper;
import cn.hncu.multiTable.domain.Student;
import cn.hncu.multiTable.domain.StudentMapper;
import cn.hncu.multiTable.domain.Teacher;
import cn.hncu.multiTable.domain.TeacherMapper;
import cn.hncu.util.MyBatisUtil;

/*
INSERT INTO student(id,NAME) VALUES(1,'张三');
INSERT INTO student(id,NAME) VALUES(2,'李四');
INSERT INTO student(id,NAME) VALUES(3,'Jack');
INSERT INTO student(id,NAME) VALUES(4,'Tom');
INSERT INTO book(NAME,price,sid) VALUES('Java','36.55',1);
INSERT INTO book(NAME,price,sid) VALUES('xml','28.32',2);
INSERT INTO book(NAME,price,sid) VALUES('MySQL','40.65',1);
INSERT INTO book(NAME,price,sid) VALUES('JSP','46',4);
 */
public class Demo {
	
	/*
		SELECT s.id sid,s.name sname,b.id bid,b.NAME bname,b.price bprice
		FROM student s 
		INNER JOIN book b 
		ON s.id=b.sid 
		ORDER BY s.id ASC
	 */
	@Test //查询哪些人有哪些书
	public void demo1() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<Student> list = sqlSession.getMapper( StudentMapper.class ).mulTabInnerJoin();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test //查询哪些书有哪些人
	public void demo2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<Book> list = sqlSession.getMapper( BookMapper.class ).mulTabQuery();
		for (Book book : list) {
			System.out.println(book+","+book.getStudent().getName());
		}
	}
	
	//查询每个人的书籍情况
	@Test
	public void demo3_1() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<Student> list = sqlSession.getMapper( StudentMapper.class ).mulTabLeftJoin();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	@Test
	public void demo3_2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<Student> list = sqlSession.getMapper( StudentMapper.class ).mulTabSubQuery();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	//查询哪些老师教了哪些学生
	@Test
	public void demo4() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<Teacher> teachers = sqlSession.getMapper(TeacherMapper.class).query1();
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}
}
