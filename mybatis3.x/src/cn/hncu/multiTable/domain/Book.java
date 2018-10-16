package cn.hncu.multiTable.domain;

import java.io.Serializable;

/*
CREATE TABLE book(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	price NUMERIC(6,2),
	sid INT,
	CONSTRAINT fk_student_book FOREIGN KEY(sid) REFERENCES student(id)
);
 */
@SuppressWarnings("serial")
public class Book implements Serializable {
	private Integer id; //主键，自动增长
	private String name;
	private Double price;
	
	//一本书只属于一个学生，存储Student，不应存储sid
	private Student student; //外键: sid 
	
	

	@Override //写toString时需注意，不要两个都输出对方的对象，不然出现死循环
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
