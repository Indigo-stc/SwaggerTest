package com.ista.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.training.models.dao.IVendedorDAO;
import com.ista.training.models.entity.Vendedor;

@Service
public class VendedorServiceImp implements IServices<Vendedor, Integer> {

	@Autowired
	private IVendedorDAO vendedorDao;;
	
	@Override
	@Transactional
	public Vendedor save(Vendedor t) {
		return vendedorDao.save(t);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Vendedor> findAll() {
		return (List<Vendedor>) vendedorDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Vendedor findById(Integer id) {
		return vendedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		vendedorDao.deleteById(id);
	}

	
}
