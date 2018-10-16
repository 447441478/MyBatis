package cn.hncu.multiTable.domain;

import java.util.List;

public interface TeacherMapper {
	/**
	 * 查询哪些老师教了哪些学生
	 * @return 
	 */
	List<Teacher> query1();
	
}
