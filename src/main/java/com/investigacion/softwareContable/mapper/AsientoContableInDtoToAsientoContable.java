package com.investigacion.softwareContable.mapper;

import com.investigacion.softwareContable.persistence.entity.AsientoContable;
import com.investigacion.softwareContable.service.dto.AsientoContableInDto;
import org.springframework.stereotype.Component;

@Component
public class AsientoContableInDtoToAsientoContable implements IMapper<AsientoContableInDto, AsientoContable>{
    @Override
    public AsientoContable map(AsientoContableInDto in) {
        AsientoContable asientoContable = new AsientoContable();
        asientoContable.setFecha(in.getFecha());
        asientoContable.setCodigoCuenta(in.getCodigoCuenta());
        asientoContable.setNombreCuenta(in.getNombreCuenta());
        asientoContable.setTercero(in.getTercero());
        asientoContable.setDebito(in.getDebito());
        asientoContable.setCredito(in.getCredito());
        asientoContable.setSaldoDebito(in.getSaldoDebito());
        asientoContable.setSaldoCredito(in.getSaldoCredito());
        asientoContable.setDiferenciaSaldo(in.getDiferenciaSaldo());
        return asientoContable;
    }
}
