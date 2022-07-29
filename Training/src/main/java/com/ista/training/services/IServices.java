package com.ista.training.services;

import java.util.List;

public interface IServices <T, ID> {
	
	public T save(T t);
	public List<T> findAll();
	public T findById(ID id);
	public void deleteById(ID id);
	
}
