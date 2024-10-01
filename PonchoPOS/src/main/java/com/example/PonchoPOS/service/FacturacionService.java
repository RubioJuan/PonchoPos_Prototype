package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Facturacion;
import com.example.PonchoPOS.repository.FacturacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturacionService {

    @Autowired
    private FacturacionRepository facturacionRepository;

    // Obtener todas las facturaciones
    public List<Facturacion> getAllFacturaciones() {
        return facturacionRepository.findAll();
    }

    // Obtener una facturación por ID
    public Optional<Facturacion> getFacturacionById(Integer id) {
        return facturacionRepository.findById(id);
    }

    // Crear una nueva facturación
    public Facturacion createFacturacion(Facturacion facturacion) {
        return facturacionRepository.save(facturacion);
    }

    // Actualizar una facturación
    public Facturacion updateFacturacion(Integer id, Facturacion facturacion) {
        facturacion.setId_factura(id);
        return facturacionRepository.save(facturacion);
    }

    // Eliminar una facturación
    public void deleteFacturacion(Integer id) {
        facturacionRepository.deleteById(id);
    }
}
