package com.example.PonchoPOS.repository;

import com.example.PonchoPOS.model.Factura_detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Factura_detalleRepository extends JpaRepository<Factura_detalle, Integer> {
}
