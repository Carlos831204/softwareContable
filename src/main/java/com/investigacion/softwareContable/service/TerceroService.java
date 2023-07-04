package com.investigacion.softwareContable.service;

import com.investigacion.softwareContable.exceptions.SoftwareContableExceptions;
import com.investigacion.softwareContable.mapper.TerceroInDTOToTercero;
import com.investigacion.softwareContable.persistence.entity.Tercero;
import com.investigacion.softwareContable.persistence.repository.TerceroRepository;
import com.investigacion.softwareContable.service.dto.TerceroInDto;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TerceroService {
    private final TerceroRepository terceroRepository;
    private final TerceroInDTOToTercero mapper;

    public TerceroService(TerceroRepository terceroRepository, TerceroInDTOToTercero mapper) {
        this.terceroRepository = terceroRepository;
        this.mapper = mapper;
    }
    public Tercero crearTercero(TerceroInDto terceroInDto){
        Tercero tercero = mapper.map(terceroInDto);
        return this.terceroRepository.save(tercero);
    }
    public List<Tercero> obtenerTerceros(){
        return this.terceroRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    public Tercero obtenerTerceroPorId(Integer id){
        return this.terceroRepository.findById(id).get();
    }

    public Tercero obtenerTerceroPorNombre(String nombre){
        return terceroRepository.findByNombreIgnoreCase(nombre);
    }

    public Tercero actualizarTercero(Integer id, TerceroInDto terceroInDto){
        Tercero terceroActualizado = terceroRepository.findById(id).get();
        if(Objects.nonNull(terceroInDto.getTipoDocumento())){
            terceroActualizado.setTipoDocumento(terceroInDto.getTipoDocumento());
        }
        if(Objects.nonNull(terceroInDto.getNombre()) && !"".equalsIgnoreCase(terceroInDto.getNombre())){
            terceroActualizado.setNombre(terceroInDto.getNombre());
        }
        if(Objects.nonNull(terceroInDto.getDocumento()) && !"".equalsIgnoreCase(terceroInDto.getDocumento())){
            terceroActualizado.setDocumento(terceroInDto.getDocumento());
        }
        if(Objects.nonNull(terceroInDto.getDireccion()) && !"".equalsIgnoreCase(terceroInDto.getDireccion())){
            terceroActualizado.setDireccion(terceroInDto.getDireccion());
        }
        if(Objects.nonNull(terceroInDto.getTelefono()) && !"".equalsIgnoreCase(terceroInDto.getTelefono())){
            terceroActualizado.setTelefono(terceroInDto.getTelefono());
        }
        if(Objects.nonNull(terceroInDto.getCorreo()) && !"".equalsIgnoreCase(terceroInDto.getCorreo())){
            terceroActualizado.setCorreo(terceroInDto.getCorreo());
        }
        return terceroRepository.save(terceroActualizado);
    }
    public void eliminarPorId(Integer id){
        Optional<Tercero> optionalTercero = this.terceroRepository.findById(id);
        if(optionalTercero.isEmpty()){
            throw new SoftwareContableExceptions("Tercero no encontrado", HttpStatus.NOT_FOUND);
        }
        this.terceroRepository.deleteById(id);
    }
}
