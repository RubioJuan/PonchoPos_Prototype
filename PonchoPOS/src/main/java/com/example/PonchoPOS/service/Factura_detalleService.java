package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Factura_detalle;
import com.example.PonchoPOS.repository.Factura_detalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Factura_detalleService {

    @Autowired
    private Factura_detalleRepository facturaDetalleRepository;

    // Obtener todos los detalles de factura
    public List<Factura_detalle> getAllDetalles() {
        return facturaDetalleRepository.findAll();
    }

    // Obtener los detalles de una factura por su ID
    public List<Factura_detalle> getDetallesByFacturaId(int id_factura) {
        return facturaDetalleRepository.findByFacturacion_Id_factura(id_factura);
    }

    // Obtener un detalle por su ID
    public Optional<Factura_detalle> getDetalleById(int id_detalle) {
        return facturaDetalleRepository.findById(id_detalle);
    }

    // Crear un nuevo detalle de factura (método separado)
    public Factura_detalle createDetalle(Factura_detalle detalle) {
        return facturaDetalleRepository.save(detalle);
    }

    // Actualizar un detalle de factura existente (método separado)
    public Factura_detalle updateDetalle(int id_detalle, Factura_detalle detalleDetails) {
        Optional<Factura_detalle> existingDetalle = facturaDetalleRepository.findById(id_detalle);

        if (existingDetalle.isPresent()) {
            Factura_detalle detalleToUpdate = existingDetalle.get();
            
            // Actualizar solo los campos necesarios
            detalleToUpdate.setFacturacion(detalleDetails.getFacturacion());
            detalleToUpdate.setId_producto(detalleDetails.getId_producto());
            detalleToUpdate.setCantidad(detalleDetails.getCantidad());
            detalleToUpdate.setPrecio_unitario(detalleDetails.getPrecio_unitario());
            detalleToUpdate.setSubtotal(detalleDetails.getSubtotal());

            return facturaDetalleRepository.save(detalleToUpdate);
        } else {
            throw new RuntimeException("Detalle no encontrado con el ID: " + id_detalle);
        }
    }

    // Eliminar un detalle de factura por su ID
    public void deleteDetalle(int id_detalle) {
        facturaDetalleRepository.deleteById(id_detalle);
    }
}
