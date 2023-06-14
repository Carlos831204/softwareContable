package com.investigacion.softwareContable.service.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@Data
public class AsientoContableInDto {
    @NotBlank(message = "Por favor ingrese la fecha")
    private Date fecha;
    @NotBlank(message = "Por favor ingrese el código de la cuenta")
    private String codigoCuenta;
    @NotBlank(message = "Por favor ingrese el nombre de la cuenta")
    private String nombreCuenta;
    @NotBlank(message = "Por favor ingrese el tercero")
    private String tercero;
    private Double debito;
    private Double credito;
    private Double saldoDebito;
    private Double saldoCredito;
    private Double diferenciaSaldo;
}
