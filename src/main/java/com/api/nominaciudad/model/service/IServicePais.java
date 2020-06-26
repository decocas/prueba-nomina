package com.api.nominaciudad.model.service;

import com.api.nominaciudad.model.entity.Pais;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IServicePais {


    public List<Pais> findByAll();

    public Pais findById(long id) throws Exception;

    public Pais findByCodigo(String s);

    public Pais save(Pais pais);

    public void delete(long id);
}
