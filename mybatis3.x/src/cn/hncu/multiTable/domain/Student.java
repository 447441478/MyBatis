package cn.hncu.multiTable.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
CREATE TABLE student(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20)
);
 */
@SuppressWarnings("serial")
public class Student implements Serializable {
	private Integer id; //主键，自动增长
	private String name;
	
	//一个学生拥有多本书，存储List<Book> 并且new出来
	private List<Book> books = new ArrayList<Book>();
	
	//一个学生被多个老师教导，所有存储老师的集合并且实例化集合
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	@Override //写toString时需注意，不要两个都输出对方的对象，不然出现死循环
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", books=" + books + "]";
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
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
	
}
