package com.example.PonchoPOS.repository;

import com.example.PonchoPOS.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
