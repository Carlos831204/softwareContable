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
    @Column(columnDefinition = "0.00")
    private Double debito;
    @Column(columnDefinition = "0.00")
    private Double credito;
    @Column(columnDefinition = "0.00")
    private Double saldoDebito;
    @Column(columnDefinition = "0.00")
    private Double saldoCredito;
    @Column(columnDefinition = "0.00")
    private Double diferenciaSaldo;

}
