package com.hibernate.demo.udemy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;	
	
	@Column(name = "title")
	private String title; 
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
			              CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH,CascadeType.MERGE,
			           CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "course_students", joinColumns = {@JoinColumn(name="course_id")} , 
	inverseJoinColumns = {@JoinColumn(name= "student_id")}) 
	private List<Student> students;
	
	public Course() {}

	public Course(String title) {
		super();
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public List<Student> getStudents() {
		if (isNullOrEmpty(students)) return null;
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	private boolean isNullOrEmpty(List<Student> students) {
		try {
			return (students.isEmpty() || students==null);
		}catch (Exception e) {
			return true;
		}		
	}
		
}
