package cn.hncu.multiTable.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Teacher implements Serializable {
	private Integer id; //主键，自动增长
	private String name;
	private String tel;
	
	//一个老师教对个学生，所有存储学生的集合并且 把集合实例
	private Set<Student> students = new HashSet<Student>(); 
	
	//显示空参构造函数
	public Teacher() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", tel=" + tel + ", students=" + students + "]";
	}
	
	
}
