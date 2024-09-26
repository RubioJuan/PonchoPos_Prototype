package com.example.PonchoPOS.Controller;

import com.example.PonchoPOS.model.Factura_detalle;
import com.example.PonchoPOS.service.Factura_detalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PonchoPos/FacturaDetalle")
public class Factura_detalleController {

    @Autowired
    private Factura_detalleService factura_detalleService;

    // Obtener todos los detalles de factura
    @GetMapping
    public List<Factura_detalle> getAllFactura_detalles() {
        return factura_detalleService.getAllFactura_detalles();
    }

    // Obtener detalle de factura por ID
    @GetMapping("/{id}")
    public Factura_detalle getFacturaDetalleById(@PathVariable Long id) {
        return factura_detalleService.getFacturaDetalleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Detalle de factura no encontrado con ID: " + id));
    }

    // Crear un detalle de factura
    @PostMapping
    public Factura_detalle createFacturaDetalle(@RequestBody Factura_detalle factura_detalle) {
        return factura_detalleService.saveFacturaDetalle(factura_detalle);
    }

    // Actualizar un detalle de factura
    @PutMapping("/{id}")
    public Factura_detalle updateFacturaDetalle(@PathVariable Long id, @RequestBody Factura_detalle factura_detalleDetails) {
        return factura_detalleService.updateFacturaDetalle(id, factura_detalleDetails);
    }

    // Eliminar un detalle de factura
    @DeleteMapping("/{id}")
    public void deleteFacturaDetalle(@PathVariable Long id) {
        factura_detalleService.deleteFacturaDetalle(id);
    }
}
