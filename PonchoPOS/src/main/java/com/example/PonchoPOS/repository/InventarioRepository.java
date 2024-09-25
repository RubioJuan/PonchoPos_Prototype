package com.example.PonchoPOS.repository;

import com.example.PonchoPOS.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}
