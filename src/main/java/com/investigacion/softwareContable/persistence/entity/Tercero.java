package com.investigacion.softwareContable.persistence.entity;

import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "tercero")
public class Tercero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTercero;
    private String nombre;
    private TipoDocumento tipoDocumento;
    private String documento;
    private String direccion;
    private String telefono;
    private String correo;
}
