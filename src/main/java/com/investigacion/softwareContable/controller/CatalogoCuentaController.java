package com.investigacion.softwareContable.controller;

import com.investigacion.softwareContable.persistence.entity.CatalogoCuenta;
import com.investigacion.softwareContable.service.CatalogoCuentaService;
import com.investigacion.softwareContable.service.dto.CatalogoCuentaInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/catalogo/cuentas")
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogoCuentaController {
    private final CatalogoCuentaService catalogoCuentaService;
    public CatalogoCuentaController(CatalogoCuentaService catalogoCuentaService) {
        this.catalogoCuentaService = catalogoCuentaService;
    }
    @PostMapping
    public CatalogoCuenta crearCuentaCatalogo(@Valid @RequestBody CatalogoCuentaInDto catalogoCuentaInDto){
        return this.catalogoCuentaService.crearCuentaCatalogo(catalogoCuentaInDto);
    }
    @GetMapping
    public List<CatalogoCuenta> obtenerCatalogoCuenta(){
        return this.catalogoCuentaService.obtenerCatalogoCuenta();
    }
    @GetMapping("/{id}")
    public CatalogoCuenta obtenerCuentaCatalogoById(@PathVariable("id") Integer id){
        return this.catalogoCuentaService.obtenerCuentaCatalogoById(id);
    }
    @GetMapping("/codigo/{codigoCuenta}")
    public CatalogoCuenta obtenerCuentaCatalogoByCodigo(@PathVariable("codigoCuenta") String codigoCuenta){
        return this.catalogoCuentaService.obtenerCuentaCatalogoByCodigo(codigoCuenta);
    }
    @GetMapping("/nombre/{nombreCuenta}")
    public CatalogoCuenta obtenerCuentaCatalogoByNombre(@PathVariable("nombreCuenta") String nombreCuenta){
        return this.catalogoCuentaService.obtenerCuentaCatalogoByNombre(nombreCuenta);
    }
    @PutMapping("/{id}")
    public CatalogoCuenta actualizarCatalogoCuenta(@PathVariable("id") Integer id, @RequestBody CatalogoCuentaInDto catalogoCuentaInDto){
        return this.catalogoCuentaService.actualizarCatalogoCuenta(id, catalogoCuentaInDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCatalogoCuentaById(@PathVariable("id") Integer id){
        this.catalogoCuentaService.eliminarCatalogoCuentaById(id);
        return ResponseEntity.noContent().build();
    }
}
