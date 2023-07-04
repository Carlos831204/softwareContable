package com.investigacion.softwareContable.service;

import com.investigacion.softwareContable.exceptions.SoftwareContableExceptions;
import com.investigacion.softwareContable.mapper.CatalogoCuentaInDtoToCatalogoCuenta;
import com.investigacion.softwareContable.persistence.entity.CatalogoCuenta;
import com.investigacion.softwareContable.persistence.repository.CatalogoCuentaRepository;
import com.investigacion.softwareContable.service.dto.CatalogoCuentaInDto;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CatalogoCuentaService {
    private final CatalogoCuentaRepository catalogoCuentaRepository;
    private final CatalogoCuentaInDtoToCatalogoCuenta mapper;

    public CatalogoCuentaService(CatalogoCuentaRepository catalogoCuentaRepository, CatalogoCuentaInDtoToCatalogoCuenta mapper) {
        this.catalogoCuentaRepository = catalogoCuentaRepository;
        this.mapper = mapper;
    }
    public CatalogoCuenta crearCuentaCatalogo(CatalogoCuentaInDto catalogoCuentaInDto){
        CatalogoCuenta catalogoCuenta = mapper.map(catalogoCuentaInDto);
        return this.catalogoCuentaRepository.save(catalogoCuenta);
    }
    public List<CatalogoCuenta> obtenerCatalogoCuenta(){
        return  this.catalogoCuentaRepository.findAll(Sort.by(Sort.Direction.ASC, "codigoCuenta"));
    }
    public CatalogoCuenta obtenerCuentaCatalogoById(Integer id){
        return this.catalogoCuentaRepository.findById(id).get();
    }
    public CatalogoCuenta obtenerCuentaCatalogoByCodigo(String codigoCuenta){
        return this.catalogoCuentaRepository.findByCodigoCuenta(codigoCuenta);
    }
    public CatalogoCuenta obtenerCuentaCatalogoByNombre(String nombreCuenta){
        return  this.catalogoCuentaRepository.findByNombreCuentaIgnoreCase(nombreCuenta);
    }
    public CatalogoCuenta actualizarCatalogoCuenta(Integer id, CatalogoCuentaInDto catalogoCuentaInDto){
        CatalogoCuenta catalogoCuentaActualizado = catalogoCuentaRepository.findById(id).get();

        if(Objects.nonNull(catalogoCuentaInDto.getCodigoCuenta()) && !"".equals(catalogoCuentaInDto.getCodigoCuenta())){
            catalogoCuentaActualizado.setCodigoCuenta(catalogoCuentaInDto.getCodigoCuenta());
        }

        if(Objects.nonNull(catalogoCuentaInDto.getNombreCuenta()) && !"".equalsIgnoreCase(catalogoCuentaInDto.getNombreCuenta())){
            catalogoCuentaActualizado.setNombreCuenta(catalogoCuentaInDto.getNombreCuenta());
        }
        return catalogoCuentaRepository.save(catalogoCuentaActualizado);
    }
    public void eliminarCatalogoCuentaById(Integer id){
        Optional<CatalogoCuenta> optionalCatalogoCuenta = this.catalogoCuentaRepository.findById(id);
        if(optionalCatalogoCuenta.isEmpty()){
            throw new SoftwareContableExceptions("La cuenta no fue encontrada dentro del catalogo", HttpStatus.NOT_FOUND);
        }
        this.catalogoCuentaRepository.deleteById(id);
    }

}
