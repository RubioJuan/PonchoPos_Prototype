package com.example.PonchoPOS.repository;

import com.example.PonchoPOS.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
    
    // Buscar x nombre
    List<Clientes> findByNombreContainingIgnoreCase(String nombre);
    
    // Buscar x ID
    Optional<Clientes> findById(Integer id);

    // Borrar x id
    void deleteById(Integer id);
}
