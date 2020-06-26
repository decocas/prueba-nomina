package com.api.nominaciudad.model.service.implement;

import com.api.nominaciudad.model.entity.Pais;

import com.api.nominaciudad.model.service.IServicePais;
import com.api.nominaciudad.repository.IPaisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicePais implements IServicePais {
    @Autowired
    private IPaisDao paisDao;


    @Override
    @Transactional(readOnly = true)
    public List<Pais> findByAll() {
        return (List<Pais>)this.paisDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pais findById(long id) throws Exception{
        Pais p=this.paisDao.findById(id).orElse(null);
        if(p==null)
            throw new Exception("esto es una falla");

        return p;
    }

    @Override
    @Transactional(readOnly = true)
    public Pais findByCodigo(String s) {
        return this.paisDao.findByCodigo(s);
    }

    @Override
    @Transactional
    public Pais save(Pais pais) {
        return this.paisDao.save(pais);
    }

    @Override
    @Transactional
    public void delete(long id) {
        this.paisDao.deleteById(id);
    }
}
