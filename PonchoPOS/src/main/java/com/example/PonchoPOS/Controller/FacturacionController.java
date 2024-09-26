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

    // Obtener todas las facturas
    @GetMapping
    public List<Facturacion> getAllFacturas() {
        return facturacionService.getAllFacturas();
    }

    // Obtener factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Facturacion> getFacturacionById(@PathVariable int id) {
        Optional<Facturacion> facturacion = facturacionService.getFacturacionById(id);
        return facturacion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar una factura
    @PostMapping
    public Facturacion saveFacturacion(@RequestBody Facturacion facturacion) {
        return facturacionService.saveFacturacion(facturacion);
    }

    // Actualizar una factura
    @PutMapping("/{id}")
    public ResponseEntity<Facturacion> updateFacturacion(@PathVariable int id, @RequestBody Facturacion facturacionDetails) {
        Facturacion updatedFacturacion = facturacionService.updateFacturacion(id, facturacionDetails);
        return ResponseEntity.ok(updatedFacturacion);
    }

    // Eliminar una factura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacturacion(@PathVariable int id) {
        facturacionService.deleteFacturacion(id);
        return ResponseEntity.noContent().build();
    }
}
