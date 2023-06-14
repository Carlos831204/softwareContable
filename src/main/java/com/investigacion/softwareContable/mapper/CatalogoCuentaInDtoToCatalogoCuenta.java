package com.investigacion.softwareContable.mapper;

import com.investigacion.softwareContable.persistence.entity.CatalogoCuenta;
import com.investigacion.softwareContable.service.dto.CatalogoCuentaInDto;
import org.springframework.stereotype.Component;

@Component
public class CatalogoCuentaInDtoToCatalogoCuenta implements IMapper<CatalogoCuentaInDto, CatalogoCuenta>{
    @Override
    public CatalogoCuenta map(CatalogoCuentaInDto in) {
        CatalogoCuenta catalogoCuenta = new CatalogoCuenta();
        catalogoCuenta.setCodigoCuenta(in.getCodigoCuenta());
        catalogoCuenta.setNombreCuenta(in.getNombreCuenta());
        return catalogoCuenta;
    }
}
