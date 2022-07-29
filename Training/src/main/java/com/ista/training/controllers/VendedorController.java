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

import com.ista.training.models.entity.Vendedor;
import com.ista.training.services.IServices;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class VendedorController {

	@Autowired
	private IServices<Vendedor, Integer> vendedorService;
	
	@GetMapping("/vendedores")
	public List<Vendedor> showAll() {
		return vendedorService.findAll();
	}
	
	@GetMapping("/vendedores/{id}")
	public Vendedor searchOne(@PathVariable Integer id) {
		return vendedorService.findById(id);
	}
	
	@PostMapping("/vendedores")
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor insert(@RequestBody Vendedor e) {
		return vendedorService.save(e);
	}
	
	@DeleteMapping("/vendedores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOne(@PathVariable Integer id) {
		vendedorService.deleteById(id);
	}
	
	@PostMapping("/vendedores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor update(@RequestBody Vendedor e, @PathVariable Integer id) {
		Vendedor current = vendedorService.findById(id);
		current.setNombre(e.getNombre());
		current.setApellido(e.getApellido());
		current.setDireccion(e.getDireccion());
		current.setTelefono(e.getTelefono());
		current.setEmail(e.getEmail());
		return vendedorService.save(current);
	}
}
