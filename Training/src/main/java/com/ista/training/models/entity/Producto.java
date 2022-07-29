package com.ista.training.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto  implements Serializable {

	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_Producto;
	private String nombre;
	private String descripcion;
	private Integer costo;
	private Integer stock;

	public Integer getId_Producto() {
		return id_Producto;
	}

	public void setId_Producto(Integer id_Producto) {
		this.id_Producto = id_Producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
