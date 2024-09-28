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

    // Obtener todas las facturas
    public List<Facturacion> getAllFacturas() {
        return facturacionRepository.findAll();
    }

    // Obtener una factura por su ID
    public Optional<Facturacion> getFacturaById(int id_factura) {
        return facturacionRepository.findById(id_factura);
    }

    // Crear una factura
    public Facturacion saveFactura(Facturacion facturacion) {
        return facturacionRepository.save(facturacion);
    }

    // Actualizar una factura existente (método separado)
    public Facturacion updateFactura(int id, Facturacion facturaDetails) {
        Optional<Facturacion> existingFactura = facturacionRepository.findById(id);

        if (existingFactura.isPresent()) {
            Facturacion facturaToUpdate = existingFactura.get();
            
            // Actualizar solo los campos de la factura
            facturaToUpdate.setNumero_factura(facturaDetails.getNumero_factura());
            facturaToUpdate.setId_cliente(facturaDetails.getId_cliente());
            facturaToUpdate.setFecha(facturaDetails.getFecha());
            facturaToUpdate.setSubtotal(facturaDetails.getSubtotal());
            facturaToUpdate.setDescuento(facturaDetails.getDescuento());
            facturaToUpdate.setIva_total(facturaDetails.getIva_total());
            facturaToUpdate.setTotal(facturaDetails.getTotal());
            facturaToUpdate.setMetodo_pago(facturaDetails.getMetodo_pago());
            facturaToUpdate.setFactura_electronica(facturaDetails.isFactura_electronica());
            facturaToUpdate.setEstado(facturaDetails.getEstado());
            
            return facturacionRepository.save(facturaToUpdate); // Guardar los cambios
        } else {
            throw new RuntimeException("Factura no encontrada con el ID: " + id);
        }
    }

    // Eliminar una factura por su ID
    public void deleteFactura(int id_factura) {
        facturacionRepository.deleteById(id_factura);
    }
}
