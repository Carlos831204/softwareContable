package com.investigacion.softwareContable.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Table(name="cuentaT")
public class CuentaT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCuentaT;
    private String codigoCuentaT;
    private String nombreCuentaT;
    @Column(columnDefinition = "0.00")
    private Double debito;
    @Column(columnDefinition = "0.00")
    private Double credito;
    @Column(columnDefinition = "0.00")
    private Double saldoDebito;
    @Column(columnDefinition = "0.00")
    private Double saldoCredito;

    @OneToMany(mappedBy = "cuentaT", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CatalogoCuenta> cuentas = new LinkedHashSet<>();
}
