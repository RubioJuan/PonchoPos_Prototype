package com.example.PonchoPOS.Controller;

import com.example.PonchoPOS.model.Facturacion;
import com.example.PonchoPOS.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PonchoPos/facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;

    // Obtener todas las facturaciones
    @GetMapping
    public List<Facturacion> getAllFacturaciones() {
        return facturacionService.getAllFacturaciones();
    }

    // Obtener una facturación por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Facturacion> getFacturacionById(@PathVariable Integer id) {
        Optional<Facturacion> facturacion = facturacionService.getFacturacionById(id);
        if (facturacion.isPresent()) {
            return ResponseEntity.ok(facturacion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva facturación
    @PostMapping
    public Facturacion createFacturacion(@RequestBody Facturacion facturacion) {
        return facturacionService.createFacturacion(facturacion);
    }

    // Actualizar una facturación existente
    @PutMapping("/{id}")
    public ResponseEntity<Facturacion> updateFacturacion(@PathVariable Integer id, @RequestBody Facturacion facturacion) {
        Optional<Facturacion> existingFacturacion = facturacionService.getFacturacionById(id);
        if (existingFacturacion.isPresent()) {
            Facturacion updatedFacturacion = facturacionService.updateFacturacion(id, facturacion);
            return ResponseEntity.ok(updatedFacturacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una facturación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacturacion(@PathVariable Integer id) {
        Optional<Facturacion> facturacion = facturacionService.getFacturacionById(id);
        if (facturacion.isPresent()) {
            facturacionService.deleteFacturacion(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
