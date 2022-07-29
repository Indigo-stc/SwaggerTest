package com.ista.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.training.models.entity.Empleado;
import com.ista.training.services.IServices;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EmpleadoController {
	
	@Autowired
	private IServices<Empleado, String> empleadoService;
	
	@GetMapping("/empleados")
	public List<Empleado> showAll() {
		return empleadoService.findAll();
	}
	
	@GetMapping("/empleados/{id}")
	public Empleado searchOne(@PathVariable String id) {
		return empleadoService.findById(id);
	}
	
	@PostMapping("/empleados")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado insert(@RequestBody Empleado e) {
		return empleadoService.save(e);
	}
	
	@DeleteMapping("/empleados/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOne(@PathVariable String id) {
		empleadoService.deleteById(id);
	}
	
	@PostMapping("/empleados/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado update(@RequestBody Empleado e, @PathVariable String id) {
		Empleado current = empleadoService.findById(id);
		current.setNombre(e.getNombre());
		current.setApellido(e.getApellido());
		current.setFecha_n(e.getFecha_n());
		current.setDireccion(e.getDireccion());
		current.setSexo(e.getSexo());
		current.setSalario(e.getSalario());
		current.setSuperCi(e.getSuperCi());
		current.setDno(e.getDno());
		return empleadoService.save(current);
	}
	
}
