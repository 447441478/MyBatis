CREATE DATABASE mybatis CHARACTER SET utf8;

USE mybatis;

CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(30),
	age INT 
);

INSERT INTO person(id,NAME,age) VALUES(1,"张三",22);
INSERT INTO person(id,NAME,age) VALUES(2,"Jack",20);
INSERT INTO person(id,NAME,age) VALUES(3,"Java",23);


CREATE TABLE USER(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(30),
	age INT 
);

INSERT INTO USER(id,NAME,age) VALUES(1,"Jack",22);
INSERT INTO USER(id,NAME,age) VALUES(2,"张三",20);
INSERT INTO USER(id,NAME,age) VALUES(3,"Java",23);


CREATE TABLE student(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20)
);

CREATE TABLE book(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	price NUMERIC(6,2),
	sid INT,
	CONSTRAINT fk_student_book FOREIGN KEY(sid) REFERENCES student(id)
);

INSERT INTO student(id,NAME) VALUES(1,'张三');
INSERT INTO student(id,NAME) VALUES(2,'李四');
INSERT INTO student(id,NAME) VALUES(3,'Jack');
INSERT INTO student(id,NAME) VALUES(4,'Tom');
INSERT INTO book(NAME,price,sid) VALUES('Java','36.55',1);
INSERT INTO book(NAME,price,sid) VALUES('xml','28.32',2);
INSERT INTO book(NAME,price,sid) VALUES('MySQL','40.65',1);
INSERT INTO book(NAME,price,sid) VALUES('JSP','46',4);

CREATE TABLE teacher(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(30),
	tel VARCHAR(20)
);

CREATE TABLE ST(
	sid INT,
	tid INT,
	CONSTRAINT pk_student_teacher PRIMARY KEY(sid,tid),
	CONSTRAINT fk_student_ST FOREIGN KEY(sid) REFERENCES student(id),
	CONSTRAINT fk_teacher_ST FOREIGN KEY(tid) REFERENCES teacher(id)
);

INSERT INTO teacher(NAME,tel) VALUES('Alice','12345678901');
INSERT INTO teacher(NAME,tel) VALUES('Bob','0737-7777777');
INSERT INTO teacher(NAME,tel) VALUES('张飞','666666');
INSERT INTO ST(sid,tid) VALUES(1,2);
INSERT INTO ST(sid,tid) VALUES(1,1);
INSERT INTO ST(sid,tid) VALUES(2,1);
INSERT INTO ST(sid,tid) VALUES(3,2);