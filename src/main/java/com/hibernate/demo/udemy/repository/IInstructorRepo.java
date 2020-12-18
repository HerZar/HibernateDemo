package com.hibernate.demo.udemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.demo.udemy.entity.Instructor;

@Repository
public interface IInstructorRepo extends JpaRepository<Instructor, Long>{

}
