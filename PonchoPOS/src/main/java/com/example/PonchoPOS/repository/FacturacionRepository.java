package com.example.PonchoPOS.repository;

import com.example.PonchoPOS.model.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturacionRepository extends JpaRepository<Facturacion, Integer> {
    Facturacion findByNumeroFactura(String numeroFactura);
}
