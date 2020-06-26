package com.api.nominaciudad.repository;

import com.api.nominaciudad.model.entity.Pais;
import org.springframework.data.repository.CrudRepository;

public interface IPaisDao extends CrudRepository<Pais,Long> {

    public Pais findByCodigo(String codigo);
}
