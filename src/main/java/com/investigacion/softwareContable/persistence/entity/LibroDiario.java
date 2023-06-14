package com.investigacion.softwareContable.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="libroDiario")
public class LibroDiario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLibroDiario;
    private Date fecha;
    private Integer idAsientoContable;
    private String codigoCuenta;
    private String nombreCuenta;
    private String tercero;
    private Double debito;
    private Double credito;
    private Double saldoDebito;
    private Double saldoCredito;
}
