package com.ista.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.training.models.dao.IProductoDAO;
import com.ista.training.models.entity.Producto;

@Service
public class ProductoServiceImp implements IServices<Producto, Integer>{

	@Autowired
	private IProductoDAO productoDao;
	
	@Override
	@Transactional
	public Producto save(Producto t) {
		return productoDao.save(t);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Integer id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		productoDao.deleteById(id);
	}
	
}
