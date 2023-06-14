package com.investigacion.softwareContable.persistence.repository;

import com.investigacion.softwareContable.persistence.entity.CatalogoCuenta;
import com.investigacion.softwareContable.persistence.entity.CuentaT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaTRepository extends JpaRepository<CuentaT, Integer> {
    public CuentaT findByCodigoCuentaT(String codigoCuentaT);
    public CuentaT findByNombreCuentaTIgnoreCase(String nombreCuentaT);

}
