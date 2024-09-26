package com.example.PonchoPOS.repository;

import com.example.PonchoPOS.model.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturacionRepository extends JpaRepository<Facturacion, Integer> {
    }
