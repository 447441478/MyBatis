package cn.hncu.multiTable.domain;

import java.util.List;

public interface StudentMapper {
	/**
	 * 查询哪些人有那些书
	 * @return 所有有书的学生集合
	 */
	List<Student> mulTabInnerJoin();
	/**
	 * 查询每个人的书籍情况
	 * @return 每个学生以及其书籍情况
	 */
	List<Student> mulTabLeftJoin();
	List<Student> mulTabSubQuery();
	
	
}
