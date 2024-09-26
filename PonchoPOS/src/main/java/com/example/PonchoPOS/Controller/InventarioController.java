package com.example.PonchoPOS.Controller;

import com.example.PonchoPOS.model.Inventario;
import com.example.PonchoPOS.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // Obtener todos los productos del inventario
    @GetMapping
    public List<Inventario> getAllInventarios() {
        return inventarioService.getAllInventarios();
    }

    // Obtener un producto del inventario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable Long id) {
        Optional<Inventario> inventario = inventarioService.getInventarioById(id);
        return inventario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto en el inventario
    @PostMapping
    public Inventario createInventario(@RequestBody Inventario inventario) {
        return inventarioService.saveInventario(inventario);
    }

    // Actualizar un producto en el inventario
    @PutMapping("/{id}")
    public ResponseEntity<Inventario> updateInventario(@PathVariable Long id, @RequestBody Inventario inventarioDetails) {
        Inventario updatedInventario = inventarioService.updateInventario(id, inventarioDetails);
        return ResponseEntity.ok(updatedInventario);
    }

    // Eliminar un producto del inventario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id) {
        inventarioService.deleteInventario(id);
        return ResponseEntity.noContent().build();
    }
}
