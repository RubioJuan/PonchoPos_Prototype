package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Factura_detalle;
import com.example.PonchoPOS.repository.Factura_detalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Factura_detalleService {

    @Autowired
    private Factura_detalleRepository facturaDetalleRepository;

    public List<Factura_detalle> getAllFacturaDetalles() {
        return facturaDetalleRepository.findAll();
    }

    public Optional<Factura_detalle> getFacturaDetalleById(Integer id) {
        return facturaDetalleRepository.findById(id);
    }

    @Transactional
    public Factura_detalle createFacturaDetalle(Factura_detalle factura_detalle) {
        return facturaDetalleRepository.save(factura_detalle);
    }

    @Transactional
    public Optional<Factura_detalle> updateFacturaDetalle(Integer id, Factura_detalle factura_detalle) {
        if (facturaDetalleRepository.existsById(id)) {
            factura_detalle.setId_detalle(id);
            return Optional.of(facturaDetalleRepository.save(factura_detalle));
        }
        return Optional.empty();
    }

    @Transactional
    public boolean deleteFacturaDetalle(Integer id) {
        if (facturaDetalleRepository.existsById(id)) {
            facturaDetalleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
