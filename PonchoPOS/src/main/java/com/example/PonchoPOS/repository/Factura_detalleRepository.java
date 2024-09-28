package com.example.PonchoPOS.repository;

import com.example.PonchoPOS.model.Factura_detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Factura_detalleRepository extends JpaRepository<Factura_detalle, Integer> {
    List<Factura_detalle> findByFacturacion_Id_factura(int id_factura);
}
