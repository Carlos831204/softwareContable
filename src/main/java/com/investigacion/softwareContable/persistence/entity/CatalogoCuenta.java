package com.investigacion.softwareContable.persistence.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "catalogoCuenta")
public class CatalogoCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCuenta;
    private String codigoCuenta;
    private String nombreCuenta;
}
