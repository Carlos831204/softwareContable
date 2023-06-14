package com.investigacion.softwareContable.service.dto;

import com.investigacion.softwareContable.persistence.entity.CatalogoCuenta;
import lombok.Data;
@Data
public class CuentaTInDto {
    private String codigoCuentaT;
    private String nombreCuentaT;
    private Double debito;
    private Double credito;
    private Double saldoDebito;
    private Double saldoCredito;
}
