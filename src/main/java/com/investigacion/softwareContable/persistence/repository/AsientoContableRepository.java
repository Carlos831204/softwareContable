package com.investigacion.softwareContable.persistence.repository;

import com.investigacion.softwareContable.persistence.entity.AsientoContable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsientoContableRepository extends JpaRepository<AsientoContable, Integer> {
}
