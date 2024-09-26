package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Facturacion;
import com.example.PonchoPOS.repository.ClientesRepository;
import com.example.PonchoPOS.repository.FacturacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturacionService {

    @Autowired
    private FacturacionRepository facturacionRepository;
    @Autowired
    private ClientesRepository clientesRepository;

    // Obtener todas las facturas
    public List<Facturacion> getAllFacturas() {
        try {
            return facturacionRepository.findAll();
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al obtener las facturas", ex);
        }
    }

    // Obtener factura por ID
    public Optional<Facturacion> getFacturacionById(Integer id) {
        try {
            return facturacionRepository.findById(id);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al obtener la factura con ID: " + id, ex);
        }
    }

    // Guardar una factura
    public Facturacion saveFacturacion(Facturacion facturacion) {
        try {
            int idCategoria = facturacion.getId_cliente();

            if (!clientesRepository.existsById(idCategoria)) {
                throw new IllegalArgumentException("La categoría con ID: " + idCategoria + " no existe.");
            }

            return facturacionRepository.save(facturacion);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al guardar la factura", ex);
        }
    }

    // Actualizar una factura
    public Facturacion updateFacturacion(Integer id, Facturacion facturacionDetails) {
        try {
            Facturacion facturacion = facturacionRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada con ID: " + id));

            int idCliente = facturacionDetails.getId_cliente();

            if (!clientesRepository.existsById(idCliente)) {
                throw new IllegalArgumentException("La categoría con ID: " + idCliente + " no existe.");
            }
            facturacion.setNumero_factura(facturacionDetails.getNumero_factura());
            facturacion.setId_cliente(idCliente);
            facturacion.setFecha(facturacionDetails.getFecha());
            facturacion.setSubtotal(facturacionDetails.getSubtotal());
            facturacion.setDescuento(facturacionDetails.getDescuento());
            facturacion.setIva_total(facturacionDetails.getIva_total());
            facturacion.setTotal(facturacionDetails.getTotal());
            facturacion.setMetodo_pago(facturacionDetails.getMetodo_pago());
            facturacion.setFactura_electronica(facturacionDetails.isFactura_electronica());
            facturacion.setEstado(facturacionDetails.getEstado());
            return facturacionRepository.save(facturacion);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al actualizar la factura con ID: " + id, ex);
        }
    }

    // Eliminar una factura
    public void deleteFacturacion(Integer id) {
        try {
            facturacionRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada con ID: " + id));
            facturacionRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al eliminar la factura con ID: " + id, ex);
        }
    }
}
