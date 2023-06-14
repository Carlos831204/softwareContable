package com.investigacion.softwareContable.mapper;

import com.investigacion.softwareContable.persistence.entity.Tercero;
import com.investigacion.softwareContable.service.dto.TerceroInDto;
import org.springframework.stereotype.Component;

@Component
public class TerceroInDTOToTercero implements IMapper<TerceroInDto, Tercero>{
    @Override
    public Tercero map(TerceroInDto in) {
        Tercero tercero = new Tercero();
        tercero.setNombre(in.getNombre());
        tercero.setTipoDocumento(in.getTipoDocumento());
        tercero.setDocumento(in.getDocumento());
        tercero.setDireccion(in.getDireccion());
        tercero.setTelefono(in.getTelefono());
        tercero.setCorreo(in.getCorreo());
        return tercero;
    }
}
