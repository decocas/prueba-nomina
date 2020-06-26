package com.api.nominaciudad.controller;

import com.api.nominaciudad.model.entity.Pais;
import com.api.nominaciudad.model.service.IServicePais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerPais {

        @Autowired
        private IServicePais servicePais;

        @GetMapping("/listaPaises")
        public List<Pais> listarTodos(){
        return this.servicePais.findByAll();
        }


        @GetMapping("/paisId/{id}")
        public  Pais listarId(@PathVariable Long id) throws Exception {
        return this.servicePais.findById(id);
        }


        @GetMapping("/paisCodigo/{codigo}")
        public Pais listarCodigo(@PathVariable String codigo){
         return this.servicePais.findByCodigo(codigo);
        }

        @PostMapping("/paisCrear")
        public Pais crear(@RequestBody Pais pais){
          return this.servicePais.save(pais);
        }

        @DeleteMapping("/borrarPais/{id}")
        public void borrar(@PathVariable long id){
                this.servicePais.delete(id);
        }




}
