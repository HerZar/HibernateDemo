package com.hibernate.demo.udemy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.hibernate.demo.udemy.entity.Course;
import com.hibernate.demo.udemy.repository.ICourseRepo;

@Service
public class CourseService implements IGenericService<Course> {

	@Autowired
	ICourseRepo repo;
	
	@Override
	public List<Course> findAll() {		
		return repo.findAll();
	}

	@Override
	public Course findById(Long idKey) {

		return repo.findById(idKey).get();
	}

	@Override
	public void save(Course model) {
		
		repo.save(model);
		
	}

	@Override
	public void deleteById(Long idKey) {
		
		repo.deleteById(idKey);
		
	}

	@Override
	public void delete(Course model) {
		
		repo.delete(model);
		
	}
	
	public List<Course> findByInstructorId(long instId) {
		List<Course> courses = repo.findByInstructorId(instId);
		return courses;
	}

	public List<Course> findByStudentId(long studentId){
		return repo.findByStudentId(studentId);
	}
	
	public Course findByTitle(String title) {
		return repo.findByTitle(title);
	}
	
	
}
