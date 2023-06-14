package com.investigacion.softwareContable.persistence.repository;

import com.investigacion.softwareContable.persistence.entity.Tercero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerceroRepository extends JpaRepository<Tercero, Integer> {
    public Tercero findByNombre(String nombre);
    public Tercero findByNombreIgnoreCase(String nombre);

}
