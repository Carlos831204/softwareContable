package com.investigacion.softwareContable.mapper;

import com.investigacion.softwareContable.persistence.entity.LibroDiario;
import com.investigacion.softwareContable.service.dto.LibroDiarioInDto;
import org.springframework.stereotype.Component;

@Component
public class LibroDiarioInDtoToLibroDiario implements IMapper<LibroDiarioInDto, LibroDiario>{
    @Override
    public LibroDiario map(LibroDiarioInDto in) {

        LibroDiario libroDiario = new LibroDiario();
        libroDiario.setFecha(in.getFecha());
        libroDiario.setIdAsientoContable(in.getIdAsientoContable());
        libroDiario.setCodigoCuenta(in.getCodigoCuenta());
        libroDiario.setNombreCuenta(in.getNombreCuenta());
        libroDiario.setTercero(in.getTercero());
        libroDiario.setDebito(in.getDebito());
        libroDiario.setCredito(in.getCredito());
        libroDiario.setSaldoDebito(in.getSaldoDebito());
        libroDiario.setSaldoCredito(in.getSaldoCredito());

        return libroDiario;
    }
}
