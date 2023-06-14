package com.investigacion.softwareContable.service.dto;

import com.investigacion.softwareContable.persistence.entity.TipoDocumento;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TerceroInDto {
    @NotBlank(message = "Por favor ingrese el nombre del tercero")
    private String nombre;
    private TipoDocumento tipoDocumento;
    @NotBlank(message = "Por favor ingrese el documento de identificación del tercero")
    private String documento;
    @NotBlank(message = "Por favor ingrese la dirección del tercero")
    private String direccion;
    @NotBlank(message = "Por favor ingrese el teléfono del tercero")
    private String telefono;
    @NotBlank(message = "Por favor ingrese el correo del tercero")
    private String correo;
}
