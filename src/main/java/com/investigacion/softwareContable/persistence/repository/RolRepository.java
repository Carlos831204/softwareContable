package com.investigacion.softwareContable.persistence.repository;

import com.investigacion.softwareContable.persistence.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
