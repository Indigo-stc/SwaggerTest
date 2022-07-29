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

import com.ista.training.models.entity.Producto;
import com.ista.training.services.IServices;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProductoController {

	@Autowired
	private IServices<Producto, Integer> productoService;
	
	@GetMapping("/productos")
	public List<Producto> showAll() {
		return productoService.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Producto searchOne(@PathVariable Integer id) {
		return productoService.findById(id);
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto insert(@RequestBody Producto e) {
		return productoService.save(e);
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOne(@PathVariable Integer id) {
		productoService.deleteById(id);
	}
	
	@PostMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto e, @PathVariable Integer id) {
		Producto current = productoService.findById(id);
		current.setNombre(e.getNombre());
		current.setDescripcion(e.getDescripcion());
		current.setCosto(e.getCosto());
		current.setStock(e.getStock());
		return productoService.save(current);
	}
	
}
