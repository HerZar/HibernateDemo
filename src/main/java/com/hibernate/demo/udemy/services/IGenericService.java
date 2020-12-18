package com.hibernate.demo.udemy.services;

import java.util.List;

public interface IGenericService<T> {
	
    public List<T> findAll();

    public  T findById (Long idKey);

    public void save(T model);

    public void deleteById(Long idKey);
    
    public void delete(T model);

}
