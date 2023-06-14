package com.investigacion.softwareContable.controller;

import com.investigacion.softwareContable.persistence.entity.LibroDiario;
import com.investigacion.softwareContable.service.LibroDiarioService;
import com.investigacion.softwareContable.service.dto.LibroDiarioInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/librodiario")
public class LibroDiarioController {
    private final LibroDiarioService libroDiarioService;
    public LibroDiarioController(LibroDiarioService libroDiarioService) {
        this.libroDiarioService = libroDiarioService;
    }
    @PostMapping
    public LibroDiario crearLibroDiario(@RequestBody LibroDiarioInDto libroDiarioInDto){
        return this.libroDiarioService.crearLibroDiario(libroDiarioInDto);
    }
    @GetMapping
    public List<LibroDiario> obtenerLibroDiario(){
        return this.libroDiarioService.obtenerLibroDario();
    }
    @GetMapping("/{id}")
    public LibroDiario obtenerLibroDiarioById(@PathVariable("id") Integer id){
        return this.libroDiarioService.obtenerLibroDarioById(id);
    }
    @PutMapping("/{id}")
    public LibroDiario actualizarLibroDiario(@PathVariable("id") Integer id, @RequestBody LibroDiarioInDto libroDiarioInDto){
        return this.libroDiarioService.actualizarLibroDiario(id, libroDiarioInDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibroDiarioById(@PathVariable("id") Integer id){
        this.libroDiarioService.eliminarLibroDiarioById(id);
        return ResponseEntity.noContent().build();
    }
}
