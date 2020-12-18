package com.hibernate.demo.udemy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hibernate.demo.udemy.entity.Course;

@Repository
public interface ICourseRepo extends JpaRepository<Course, Long>{
	@Query("SELECT c FROM Course c WHERE c.instructor.id = :insId")
	public List<Course> findByInstructorId(@Param("insId") long insId);
	
	@Query("SELECT c FROM Course c join c.students s WHERE s.id = :studentId")
	public List<Course> findByStudentId(@Param("studentId") long studentId);
	
	public Course findByTitle(String title);
		
}
