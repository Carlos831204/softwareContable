package com.investigacion.softwareContable.controller;

import com.investigacion.softwareContable.persistence.entity.AsientoContable;
import com.investigacion.softwareContable.service.AsientoContableService;
import com.investigacion.softwareContable.service.dto.AsientoContableInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asientocontable")
@CrossOrigin(origins = "http://localhost:4200")
public class AsientoContableController {
    private final AsientoContableService asientoContableService;
    public AsientoContableController(AsientoContableService asientoContableService) {
        this.asientoContableService = asientoContableService;
    }
    @PostMapping
    public AsientoContable crearAsientoContable(@RequestBody AsientoContableInDto asientoContableInDto){
        return this.asientoContableService.crearAsientoContable(asientoContableInDto);
    }
    @GetMapping
    public List<AsientoContable> obtenerAsientosContables(){
        return this.asientoContableService.obtenerAsientoContable();
    }
    @GetMapping("/{id}")
    public AsientoContable obtenerAsientoContableById(@PathVariable("id") Integer id){
        return this.asientoContableService.obtenerAsientoContableById(id);
    }
    @PutMapping("/{id}")
    public AsientoContable actualizarAsientoContable(@PathVariable("id") Integer id, @RequestBody AsientoContableInDto asientoContableInDto){
        return this.asientoContableService.actualizarAsientoContable(id, asientoContableInDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsientoContableById(@PathVariable("id") Integer id){
        this.asientoContableService.eliminarAsientoContableById(id);
        return ResponseEntity.noContent().build();
    }
}
