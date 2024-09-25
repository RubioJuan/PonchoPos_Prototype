package com.example.PonchoPOS.repository;

import com.example.PonchoPOS.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
