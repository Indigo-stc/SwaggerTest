package com.ista.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.training.models.dao.IEmpleadoDAO;
import com.ista.training.models.entity.Empleado;

@Service
public class EmpleadoServiceImp implements IServices<Empleado, String>{

	@Autowired
	private IEmpleadoDAO empleadoDao;
	
	@Override
	@Transactional
	public Empleado save(Empleado t) {
		return empleadoDao.save(t);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Empleado> findAll() {
		return (List<Empleado>) empleadoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado findById(String id) {
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		empleadoDao.deleteById(id);
	}

}
