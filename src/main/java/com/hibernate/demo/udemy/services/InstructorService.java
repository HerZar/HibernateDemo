package com.hibernate.demo.udemy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.demo.udemy.entity.Instructor;
import com.hibernate.demo.udemy.repository.IInstructorRepo;

@Service
public class InstructorService implements IGenericService<Instructor> {

	@Autowired
	IInstructorRepo repo;
	
	@Override
	public List<Instructor> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Instructor findById(Long idKey) {
		Instructor aux =repo.findById(idKey).get();
		System.out.println(aux);
		return aux;
	}

	@Override
	public void save(Instructor model) {
		this.repo.save(model);
	}

	@Override
	public void deleteById(Long idKey) {
		this.repo.deleteById(idKey);
		
	}

	@Override
	public void delete(Instructor model) {
		this.repo.delete(model);
		
	}

}
