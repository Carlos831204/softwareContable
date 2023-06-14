package com.investigacion.softwareContable.service.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
public class LibroDiarioInDto {
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
