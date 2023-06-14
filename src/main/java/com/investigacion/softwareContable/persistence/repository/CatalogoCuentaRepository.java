package com.investigacion.softwareContable.persistence.repository;

import com.investigacion.softwareContable.persistence.entity.CatalogoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoCuentaRepository extends JpaRepository<CatalogoCuenta, Integer> {
    public CatalogoCuenta findByCodigoCuenta(String codigoCuenta);
    public CatalogoCuenta findByNombreCuentaIgnoreCase(String nombreCuenta);
}
