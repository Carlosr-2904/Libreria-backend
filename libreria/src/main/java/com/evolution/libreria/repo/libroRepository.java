package com.evolution.libreria.repo;

import com.evolution.libreria.model.libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface libroRepository extends JpaRepository<libro, Integer> {}
