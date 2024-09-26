package com.example.PonchoPOS.Controller;

import com.example.PonchoPOS.model.Categoria;
import com.example.PonchoPOS.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Cambiado a RestController para trabajar con JSON
@RequestMapping("/api/categorias") // Ajuste en la ruta para hacerlo más común en APIs
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Obtener todas las categorías (GET)
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    // Obtener una categoría por ID (GET)
    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoryByID(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con ID: " + id));
    }

    // Crear o actualizar una categoría (POST o PUT)
    @PostMapping("/guardar")
    public Categoria saveOrUpdateCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    // Actualizar una categoría (PUT)
    @PutMapping("/actualizar/{id}")
    public Categoria updateCategoria(@PathVariable Long id, @RequestBody Categoria categoriaDetails) {
        Categoria categoria = categoriaService.getCategoryByID(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con ID: " + id));

        categoria.setNombre(categoriaDetails.getNombre());  // Ajusta según los campos que tengas
        categoria.setDescripcion(categoriaDetails.getDescripcion()); // Ajusta según los campos que tengas
        return categoriaService.saveCategoria(categoria);
    }

    // Eliminar una categoría (DELETE)
    @DeleteMapping("/eliminar/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }
}
