package com.springboot.h2.modelo.dao;

import com.springboot.h2.modelo.entidad.Coches;
import org.springframework.data.repository.CrudRepository;

public interface ICochesDao extends CrudRepository<Coches, Long> {
}
