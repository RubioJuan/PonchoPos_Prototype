package com.example.PonchoPOS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PonchoPOS.model.Factura_detalle;
import com.example.PonchoPOS.service.Factura_detalleService;

@RestController
@RequestMapping("/PonchoPos/factura_detaller")
public class Factura_detalleController {

    private final Factura_detalleService factura_detalleService;

    @Autowired
    public Factura_detalleController(Factura_detalleService factura_detalleService) {
        this.factura_detalleService = factura_detalleService;
    }

    @GetMapping
    public ResponseEntity<List<Factura_detalle>> getAllFacturaDetalles() {
        List<Factura_detalle> detalles = factura_detalleService.getAllFacturaDetalles();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura_detalle> getFacturaDetalleById(@PathVariable Integer id) {
        return factura_detalleService.getFacturaDetalleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Factura_detalle> createFacturaDetalle(@RequestBody Factura_detalle factura_detalle) {
        Factura_detalle createdDetalle = factura_detalleService.createFacturaDetalle(factura_detalle);
        return ResponseEntity.status(201).body(createdDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura_detalle> updateFacturaDetalle(@PathVariable Integer id, @RequestBody Factura_detalle factura_detalle) {
        return factura_detalleService.updateFacturaDetalle(id, factura_detalle)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacturaDetalle(@PathVariable Integer id) {
        if (factura_detalleService.deleteFacturaDetalle(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
