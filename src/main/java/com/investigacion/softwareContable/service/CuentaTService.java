package com.investigacion.softwareContable.service;

import com.investigacion.softwareContable.exceptions.SoftwareContableExceptions;
import com.investigacion.softwareContable.mapper.CuentaTInDtoToCuentaT;
import com.investigacion.softwareContable.persistence.entity.CuentaT;
import com.investigacion.softwareContable.persistence.repository.CuentaTRepository;
import com.investigacion.softwareContable.service.dto.CuentaTInDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CuentaTService {
    private final CuentaTRepository cuentaTRepository;
    private final CuentaTInDtoToCuentaT mapper;

    public CuentaTService(CuentaTRepository cuentaTRepository, CuentaTInDtoToCuentaT mapper) {
        this.cuentaTRepository = cuentaTRepository;
        this.mapper = mapper;
    }
    public CuentaT crearCuentaT(CuentaTInDto cuentaTInDto){
        CuentaT cuentaT = mapper.map(cuentaTInDto);
        return this.cuentaTRepository.save(cuentaT);
    }
    public List<CuentaT> obtenerCuentasT(){
        return this.cuentaTRepository.findAll();
    }
    public CuentaT obtenerCuentaTById(Integer id){
        return this.cuentaTRepository.findById(id).get();
    }
    public CuentaT obtenerCuentaTByCodigo(String codigCuentaT){
        return this.cuentaTRepository.findByCodigoCuentaT(codigCuentaT);
    }
    public CuentaT obtenerCuentaByNombre(String nombreCuentaT){
        return this.cuentaTRepository.findByNombreCuentaTIgnoreCase(nombreCuentaT);
    }
    public CuentaT actualizarCuentaT(Integer id, CuentaTInDto cuentaTInDto){
        CuentaT cuentaTActualizada = cuentaTRepository.findById(id).get();
        if(Objects.nonNull(cuentaTInDto.getCodigoCuentaT()) && !"".equals(cuentaTInDto.getCodigoCuentaT())){
            cuentaTActualizada.setCodigoCuentaT(cuentaTInDto.getCodigoCuentaT());
        }

        if(Objects.nonNull(cuentaTInDto.getNombreCuentaT()) && !"".equalsIgnoreCase(cuentaTInDto.getNombreCuentaT())){
            cuentaTActualizada.setNombreCuentaT(cuentaTInDto.getNombreCuentaT());
        }

        if(Objects.nonNull(cuentaTInDto.getDebito())){
            cuentaTActualizada.setDebito(cuentaTInDto.getDebito());
        }

        if(Objects.nonNull(cuentaTInDto.getCredito())){
            cuentaTActualizada.setCredito(cuentaTInDto.getCredito());
        }

        if(Objects.nonNull(cuentaTInDto.getSaldoCredito())){
            cuentaTActualizada.setSaldoCredito(cuentaTInDto.getSaldoCredito());
        }

        if(Objects.nonNull(cuentaTInDto.getSaldoDebito())){
            cuentaTActualizada.setSaldoDebito(cuentaTInDto.getSaldoDebito());
        }
        return cuentaTRepository.save(cuentaTActualizada);
    }
    public void eliminarCuentaTById(Integer id){
        Optional<CuentaT> optionalCuentaT = this.cuentaTRepository.findById(id);
        if(optionalCuentaT.isEmpty()){
            throw new SoftwareContableExceptions("La cuenta T no se encuentra", HttpStatus.NOT_FOUND);
        }
        this.cuentaTRepository.deleteById(id);
    }
}
