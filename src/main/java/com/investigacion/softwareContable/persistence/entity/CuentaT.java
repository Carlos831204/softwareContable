package com.investigacion.softwareContable.persistence.entity;

import lombok.Data;
import javax.persistence.*;
@Entity
@Data
@Table(name="cuentaT")
public class CuentaT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCuentaT;
    private String codigoCuentaT;
    private String nombreCuentaT;
    private Double debito;
    private Double credito;
    private Double saldoDebito;
    private Double saldoCredito;
}
