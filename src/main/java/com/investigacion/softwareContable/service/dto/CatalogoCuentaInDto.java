package com.investigacion.softwareContable.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CatalogoCuentaInDto {
    @NotBlank(message = "Por favor ingrese el codigo de la cuenta")
    private String codigoCuenta;
    @NotBlank(message = "Por favor ingrese el nombre de la cuenta")
    private String nombreCuenta;
}
