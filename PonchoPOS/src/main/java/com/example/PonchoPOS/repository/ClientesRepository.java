package com.example.PonchoPOS.repository;

import com.example.PonchoPOS.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> { // Usa Integer para que coincida con el tipo de id_cliente
}
