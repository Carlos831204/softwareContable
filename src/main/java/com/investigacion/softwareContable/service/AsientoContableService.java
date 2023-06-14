package com.investigacion.softwareContable.service;

import com.investigacion.softwareContable.exceptions.SoftwareContableExceptions;
import com.investigacion.softwareContable.mapper.AsientoContableInDtoToAsientoContable;
import com.investigacion.softwareContable.persistence.entity.AsientoContable;
import com.investigacion.softwareContable.persistence.repository.AsientoContableRepository;
import com.investigacion.softwareContable.service.dto.AsientoContableInDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AsientoContableService {
    private final AsientoContableRepository asientoContableRepository;
    private final AsientoContableInDtoToAsientoContable mapper;
    public AsientoContableService(AsientoContableRepository asientoContableRepository, AsientoContableInDtoToAsientoContable mapper) {
        this.asientoContableRepository = asientoContableRepository;
        this.mapper = mapper;
    }
    public AsientoContable crearAsientoContable(AsientoContableInDto asientoContableInDto){
        AsientoContable asientoContable = mapper.map(asientoContableInDto);
        return this.asientoContableRepository.save(asientoContable);
    }
    public List<AsientoContable> obtenerAsientoContable(){
        return this.asientoContableRepository.findAll();
    }
    public AsientoContable obtenerAsientoContableById(Integer id){
        return this.asientoContableRepository.findById(id).get();
    }
    public AsientoContable actualizarAsientoContable(Integer id, AsientoContableInDto asientoContableInDto){
        AsientoContable asientoContableActualizado = asientoContableRepository.findById(id).get();
        if(Objects.nonNull(asientoContableInDto.getFecha())){
            asientoContableActualizado.setFecha(asientoContableInDto.getFecha());
        }
        if(Objects.nonNull(asientoContableInDto.getCodigoCuenta()) && !"".equals(asientoContableInDto.getCodigoCuenta())){
            asientoContableActualizado.setCodigoCuenta(asientoContableInDto.getCodigoCuenta());
        }
        if(Objects.nonNull(asientoContableInDto.getNombreCuenta()) && !"".equalsIgnoreCase(asientoContableInDto.getNombreCuenta())){
            asientoContableActualizado.setNombreCuenta(asientoContableInDto.getNombreCuenta());
        }
        if(Objects.nonNull(asientoContableInDto.getTercero()) && !"".equalsIgnoreCase(asientoContableInDto.getTercero())){
            asientoContableActualizado.setTercero(asientoContableInDto.getTercero());
        }
        if(Objects.nonNull(asientoContableInDto.getDebito())){
            asientoContableActualizado.setDebito(asientoContableInDto.getDebito());
        }
        if(Objects.nonNull(asientoContableInDto.getCredito())){
            asientoContableActualizado.setCredito(asientoContableInDto.getCredito());
        }
        if(Objects.nonNull(asientoContableInDto.getSaldoDebito())){
            asientoContableActualizado.setSaldoDebito(asientoContableInDto.getSaldoDebito());
        }
        if(Objects.nonNull(asientoContableInDto.getSaldoCredito())){
            asientoContableActualizado.setSaldoCredito(asientoContableInDto.getSaldoCredito());
        }
        if(Objects.nonNull(asientoContableInDto.getDiferenciaSaldo())){
            asientoContableActualizado.setDiferenciaSaldo(asientoContableInDto.getDiferenciaSaldo());
        }
        return asientoContableRepository.save(asientoContableActualizado);
    }
    public void eliminarAsientoContableById(Integer id){
        Optional<AsientoContable> optionalAsientoContable = this.asientoContableRepository.findById(id);
        if(optionalAsientoContable.isEmpty()){
            throw new SoftwareContableExceptions("El asiento contable no se encuentra", HttpStatus.NOT_FOUND);
        }
        this.asientoContableRepository.deleteById(id);
    }
}
