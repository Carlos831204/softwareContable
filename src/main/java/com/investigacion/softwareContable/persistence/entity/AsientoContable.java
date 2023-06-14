package com.investigacion.softwareContable.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Table(name="asiento")
public class AsientoContable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAsiento;
    private Date fecha;
    private String codigoCuenta;
    private String nombreCuenta;
    private String tercero;
    private Double debito;
    private Double credito;
    private Double saldoDebito;
    private Double saldoCredito;
    private Double diferenciaSaldo;

}
