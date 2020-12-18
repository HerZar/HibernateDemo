package com.hibernate.demo.udemy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hibernate.demo.udemy.entity.Course;
import com.hibernate.demo.udemy.entity.Student;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Long>{

	@Query("SELECT s FROM Student s join s.courses c WHERE c.id = :courseId")
	List<Student> findByCourseId(@Param("courseId") long courseId);
	
}
