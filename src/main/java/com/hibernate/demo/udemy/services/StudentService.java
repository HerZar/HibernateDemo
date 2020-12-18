package com.hibernate.demo.udemy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.demo.udemy.entity.Student;
import com.hibernate.demo.udemy.repository.IStudentRepo;

@Service
public class StudentService implements IGenericService<Student> {

	@Autowired
	IStudentRepo repo;

	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public Student findById(Long idKey) {		
		return repo.findById(idKey).get();
	}

	@Override
	public void save(Student model) {
		this.repo.save(model);
		
	}

	@Override
	public void deleteById(Long idKey) {
		this.repo.deleteById(idKey);
		
	}

	@Override
	public void delete(Student model) {
		this.repo.delete(model);
		
	}

	public List<Student> findByCourseId(long courseId){
		return this.repo.findByCourseId(courseId);
		
	}

}
