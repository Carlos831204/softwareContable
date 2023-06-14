package com.investigacion.softwareContable.persistence.repository;

import com.investigacion.softwareContable.persistence.entity.LibroDiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroDiarioRepository extends JpaRepository<LibroDiario, Integer> {
}
