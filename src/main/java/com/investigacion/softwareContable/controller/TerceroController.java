package com.investigacion.softwareContable.controller;

import com.investigacion.softwareContable.persistence.entity.Tercero;
import com.investigacion.softwareContable.service.TerceroService;
import com.investigacion.softwareContable.service.dto.TerceroInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/terceros")
@CrossOrigin(origins = "http://localhost:4200")
public class TerceroController {
    private final TerceroService terceroService;

    public TerceroController(TerceroService terceroService) {
        this.terceroService = terceroService;
    }
    @PostMapping
    public Tercero crearTercero(@Valid @RequestBody TerceroInDto terceroInDto){
        return this.terceroService.crearTercero(terceroInDto);
    }
    @GetMapping
    public List<Tercero> obtenerTerceros(){
        return this.terceroService.obtenerTerceros();
    }
    @GetMapping("/{id}")
    public Tercero obtenerTerceroPorId(@PathVariable("id") Integer id){
        return this.terceroService.obtenerTerceroPorId(id);
    }
    @GetMapping("/nombre/{nombre}")
    public Tercero obtenerTerceroPorNombre(@PathVariable("nombre") String nombre){
        return this.terceroService.obtenerTerceroPorNombre(nombre);
    }

    @PutMapping("/{id}")
    public Tercero actualizarTercero(@PathVariable("id") Integer id, @RequestBody TerceroInDto terceroInDto){
        return terceroService.actualizarTercero(id, terceroInDto);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTercero(@PathVariable("id") Integer id){
        this.terceroService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
