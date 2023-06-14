package com.investigacion.softwareContable.controller;

import com.investigacion.softwareContable.persistence.entity.CuentaT;
import com.investigacion.softwareContable.service.CuentaTService;
import com.investigacion.softwareContable.service.dto.CuentaTInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentaT")
public class CuentaTController {
    private final CuentaTService cuentaTService;
    public CuentaTController(CuentaTService cuentaTService) {
        this.cuentaTService = cuentaTService;
    }
    @PostMapping
    public CuentaT crearCuentaT(@RequestBody CuentaTInDto cuentaTInDto){
        return this.cuentaTService.crearCuentaT(cuentaTInDto);
    }
    @GetMapping
    public List<CuentaT> obtenerCuentasT(){
        return this.cuentaTService.obtenerCuentasT();
    }
    @GetMapping("/{id}")
    public CuentaT obtenerCuentaTById(@PathVariable("id") Integer id){
        return this.cuentaTService.obtenerCuentaTById(id);
    }
    @GetMapping("/codigo/{codigoCuentaT}")
    public CuentaT obtenerCuentaTByCodigo(@PathVariable("codigoCuentaT") String codigoCuentaT){
        return this.cuentaTService.obtenerCuentaTByCodigo(codigoCuentaT);
    }
    @GetMapping("/nombre/{nombreCuentaT}")
    public CuentaT obtenerCuentaTByNombre(@PathVariable("nombreCuentaT") String nombreCuentaT){
        return this.cuentaTService.obtenerCuentaByNombre(nombreCuentaT);
    }
    @PutMapping("/{id}")
    public CuentaT actualizarCuentaT(@PathVariable("id") Integer id, @RequestBody CuentaTInDto cuentaTInDto){
        return this.cuentaTService.actualizarCuentaT(id, cuentaTInDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuentaTById(@PathVariable("id") Integer id){
        this.cuentaTService.eliminarCuentaTById(id);
        return ResponseEntity.noContent().build();
    }
}
