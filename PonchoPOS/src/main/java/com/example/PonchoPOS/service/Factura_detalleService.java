package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Factura_detalle;
import com.example.PonchoPOS.repository.Factura_detalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Factura_detalleService {

    @Autowired
    private Factura_detalleRepository factura_detalleRepository;

    // Obtener todos los detalles de factura
    public List<Factura_detalle> getAllFactura_detalles() {
        try {
            return factura_detalleRepository.findAll();
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al obtener los detalles de factura", ex);
        }
    }

    // Obtener detalle de factura por ID
    public Optional<Factura_detalle> getFacturaDetalleById(Long id) {
        try {
            return factura_detalleRepository.findById(id);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al obtener el detalle de factura con ID: " + id, ex);
        }
    }

    // Guardar un detalle de factura
    public Factura_detalle saveFacturaDetalle(Factura_detalle factura_detalle) {
        try {
            return factura_detalleRepository.save(factura_detalle);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al guardar el detalle de factura", ex);
        }
    }

    // Actualizar un detalle de factura
    public Factura_detalle updateFacturaDetalle(Long id, Factura_detalle factura_detalleDetails) {
        try {
            Factura_detalle factura_detalle = factura_detalleRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Detalle de factura no encontrado con ID: " + id));

            // Usar los métodos de set correctos
            factura_detalle.setCantidad(factura_detalleDetails.getCantidad());
            factura_detalle.setPrecio_unitario(factura_detalleDetails.getPrecio_unitario());
            factura_detalle.setId_producto(factura_detalleDetails.getId_producto());

            return factura_detalleRepository.save(factura_detalle);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al actualizar el detalle de factura con ID: " + id, ex);
        }
    }

    // Eliminar un detalle de factura
    public void deleteFacturaDetalle(Long id) {
        try {
            factura_detalleRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Detalle de factura no encontrado con ID: " + id));
            factura_detalleRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al eliminar el detalle de factura con ID: " + id, ex);
        }
    }
}
