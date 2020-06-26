package com.api.nominaciudad.model.service;


import com.api.nominaciudad.model.entity.Pais;
import com.api.nominaciudad.model.service.implement.ServicePais;
import com.api.nominaciudad.repository.IPaisDao;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaisServiceTest {

    @Mock
    private IPaisDao iPaisDao;
    @Mock
    private Pais pais;
    @Mock
    private List<Pais> paisList;
    @InjectMocks
    private ServicePais servicePais;

    @Before
    public void setUp(){
        this.paisList=new ArrayList<Pais>();
        pais=new Pais(1L,"chile","01");
        paisList.add(pais);
    }
/*compa configure en file/settigs/runtest with intellij*/
@Test
public void listarAllTest(){
    when(iPaisDao.findAll()).thenReturn(this.paisList);
    Assertions.assertThat(1).isEqualTo(this.servicePais.findByAll().size());
}


//@Test(expected = Exception.class) esperando una excepcion
@Test
    public  void listarIdTest() throws Exception {
    System.out.println("estoy esperando una falla");
    when(iPaisDao.findById(1L)).thenReturn(Optional.ofNullable(pais));
    Assertions.assertThat(pais).isEqualTo(this.servicePais.findById(1L));
}

@Test
    public void listarCodigoTes(){
    when(this.iPaisDao.findByCodigo("01")).thenReturn((pais));
    Assertions.assertThat(pais).isEqualTo(this.servicePais.findByCodigo("01"));
}

@Test
    public void agregarPaisTest(){
    Pais nuevo=new Pais();
    when(this.iPaisDao.save(nuevo)).thenReturn(nuevo);
    Assertions.assertThat(nuevo).isEqualTo(this.servicePais.save(nuevo));
}

@Test
    public void borrarTest(){
    this.servicePais.delete(1L);
    verify(this.iPaisDao,times(1)).deleteById(1L);
    }




}
