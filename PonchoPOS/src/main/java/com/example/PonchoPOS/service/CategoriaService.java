package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Categoria;
import com.example.PonchoPOS.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> getAllCategorias() {
        try {
            return categoriaRepository.findAll();
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al obtener las categorías", ex);
        }
    }

    // Obtener una categoría por ID
    public Optional<Categoria> getCategoryByID(Long id) {
        try {
            return categoriaRepository.findById(id);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al obtener la categoría con ID: " + id, ex);
        }
    }

    // Guardar una categoría
    public Categoria saveCategoria(Categoria categoria) {
        try {
            return categoriaRepository.save(categoria);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al guardar la categoría", ex);
        }
    }

    // Actualizar una categoría
    public Categoria updateCategoria(Long id, Categoria categoriaDetails) {
        try {
            Categoria categoria = categoriaRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con ID: " + id));
            categoria.setNombre(categoriaDetails.getNombre());
            categoria.setUbicacion(categoriaDetails.getUbicacion());
            categoria.setDescripcion(categoriaDetails.getDescripcion());
            categoria.setActivo(categoriaDetails.isActivo());
            return categoriaRepository.save(categoria);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al actualizar la categoría con ID: " + id, ex);
        }
    }

    // Eliminar una categoría
    public void deleteCategoria(Long id) {
        try {
            Categoria categoria = categoriaRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con ID: " + id));
            categoriaRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al eliminar la categoría con ID: " + id, ex);
        }
    }
}
