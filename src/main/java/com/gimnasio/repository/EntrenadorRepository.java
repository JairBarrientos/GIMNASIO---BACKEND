package com.gimnasio.repository;

import com.gimnasio.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {
}
