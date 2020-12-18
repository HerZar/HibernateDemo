package com.hibernate.demo.udemy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hibernate.demo.udemy.services.CourseService;

@Entity
@Table(name="instructor")
public class Instructor {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private  String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id" )
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH,CascadeType.MERGE,
			           CascadeType.PERSIST,CascadeType.REFRESH})	
	private List<Course> courses;
	
	public Instructor() {
		
	}


	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}


	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	public List<Course> getCourses(CourseService repo) {
		if (isNullOrEmpty(courses)) {
			this.courses = repo.findByInstructorId(this.getId());
		}
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

	// este un metodo coveniente para relaciones bidireccionales
	public void add(Course course, CourseService repo) {
		if (isNullOrEmpty(courses)) {
			this.courses = repo.findByInstructorId(this.getId());
		}
		this.courses.add(course);
		course.setInstructor(this);
	}
	
	// este un metodo coveniente para relaciones bidireccionales
	public void add(Course course) {
		if (isNullOrEmpty(courses)) {
			this.courses = new ArrayList<Course>();
		}
		this.courses.add(course);
		course.setInstructor(this);
	}


	private boolean isNullOrEmpty(List<Course> courses) {
		try {
			return (courses.isEmpty() || courses==null);
		}catch (Exception e) {
			return true;
		}		
	}
	
}
