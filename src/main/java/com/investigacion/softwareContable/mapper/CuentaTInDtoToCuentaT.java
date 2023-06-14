package com.investigacion.softwareContable.mapper;

import com.investigacion.softwareContable.persistence.entity.CuentaT;
import com.investigacion.softwareContable.service.dto.CuentaTInDto;
import org.springframework.stereotype.Component;

@Component
public class CuentaTInDtoToCuentaT implements IMapper<CuentaTInDto, CuentaT>{
    @Override
    public CuentaT map(CuentaTInDto in) {
        CuentaT cuentaT = new CuentaT();
        cuentaT.setCodigoCuentaT(in.getCodigoCuentaT());
        cuentaT.setNombreCuentaT(in.getNombreCuentaT());
        cuentaT.setDebito(in.getDebito());
        cuentaT.setCredito(in.getCredito());
        cuentaT.setSaldoDebito(in.getSaldoDebito());
        cuentaT.setSaldoCredito(in.getSaldoCredito());
        return cuentaT;
    }
}
