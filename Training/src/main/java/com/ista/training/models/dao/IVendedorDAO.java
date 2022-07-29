package com.ista.training.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ista.training.models.entity.Vendedor;

@Repository
public interface IVendedorDAO extends CrudRepository<Vendedor, Integer> {

}
