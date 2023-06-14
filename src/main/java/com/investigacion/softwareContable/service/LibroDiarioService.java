package com.investigacion.softwareContable.service;

import com.investigacion.softwareContable.exceptions.SoftwareContableExceptions;
import com.investigacion.softwareContable.mapper.LibroDiarioInDtoToLibroDiario;
import com.investigacion.softwareContable.persistence.entity.LibroDiario;
import com.investigacion.softwareContable.persistence.repository.LibroDiarioRepository;
import com.investigacion.softwareContable.service.dto.LibroDiarioInDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LibroDiarioService {
    private final LibroDiarioRepository libroDiarioRepository;
    private final LibroDiarioInDtoToLibroDiario mapper;
    public LibroDiarioService(LibroDiarioRepository libroDiarioRepository, LibroDiarioInDtoToLibroDiario mapper) {
        this.libroDiarioRepository = libroDiarioRepository;
        this.mapper = mapper;
    }
    public LibroDiario crearLibroDiario(LibroDiarioInDto libroDiarioInDto){
        LibroDiario libroDiario = mapper.map(libroDiarioInDto);
        return this.libroDiarioRepository.save(libroDiario);
    }
    public List<LibroDiario> obtenerLibroDario(){
        return this.libroDiarioRepository.findAll();
    }
    public LibroDiario obtenerLibroDarioById(Integer id){
        return this.libroDiarioRepository.findById(id).get();
    }
    public LibroDiario actualizarLibroDiario(Integer id, LibroDiarioInDto libroDiarioInDto){
        LibroDiario libroDiarioActualizado = libroDiarioRepository.findById(id).get();

        if(Objects.nonNull(libroDiarioInDto.getFecha())){
            libroDiarioActualizado.setFecha(libroDiarioInDto.getFecha());
        }
        if(Objects.nonNull(libroDiarioInDto.getIdAsientoContable())){
            libroDiarioActualizado.setIdAsientoContable(libroDiarioInDto.getIdAsientoContable());
        }
        if(Objects.nonNull(libroDiarioInDto.getCodigoCuenta()) && !"".equals(libroDiarioInDto.getCodigoCuenta())){
            libroDiarioActualizado.setCodigoCuenta(libroDiarioInDto.getCodigoCuenta());
        }
        if(Objects.nonNull(libroDiarioInDto.getNombreCuenta()) && !"".equalsIgnoreCase(libroDiarioInDto.getNombreCuenta())){
            libroDiarioActualizado.setNombreCuenta(libroDiarioInDto.getNombreCuenta());
        }
        if(Objects.nonNull(libroDiarioInDto.getTercero()) && !"".equalsIgnoreCase(libroDiarioInDto.getTercero())){
            libroDiarioActualizado.setTercero(libroDiarioInDto.getTercero());
        }
        if(Objects.nonNull(libroDiarioInDto.getDebito())){
            libroDiarioActualizado.setDebito(libroDiarioInDto.getDebito());
        }
        if(Objects.nonNull(libroDiarioInDto.getCredito())){
            libroDiarioActualizado.setCredito(libroDiarioInDto.getCredito());
        }
        if(Objects.nonNull(libroDiarioInDto.getSaldoDebito())){
            libroDiarioActualizado.setSaldoDebito(libroDiarioInDto.getSaldoDebito());
        }
        if(Objects.nonNull(libroDiarioInDto.getSaldoCredito())){
            libroDiarioActualizado.setSaldoCredito(libroDiarioInDto.getSaldoCredito());
        }
        return this.libroDiarioRepository.save(libroDiarioActualizado);
    }
    public void eliminarLibroDiarioById(Integer id){
        Optional<LibroDiario> optionalLibroDiario = this.libroDiarioRepository.findById(id);
        if(optionalLibroDiario.isEmpty()){
            throw new SoftwareContableExceptions("El libro diario no existe", HttpStatus.NOT_FOUND);
        }
        this.libroDiarioRepository.deleteById(id);
    }
}
