package com.investigacion.softwareContable.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "idCuentaT")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CuentaT cuentaT;
}
