package com.api.nominaciudad.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "paises")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pais implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private String nombre;
private String codigo;

}
