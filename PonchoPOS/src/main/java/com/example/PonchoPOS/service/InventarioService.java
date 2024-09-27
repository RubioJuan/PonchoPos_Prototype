package com.example.PonchoPOS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.PonchoPOS.model.Inventario;
import com.example.PonchoPOS.repository.CategoriaRepository;
import com.example.PonchoPOS.repository.InventarioRepository;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todos los productos del inventario
    public List<Inventario> getAllInventarios() {
        try {
            return inventarioRepository.findAll();
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al obtener los productos del inventario", ex);
        }
    }

    // Obtener producto del inventario por ID
    public Optional<Inventario> getInventarioById(Long id) {
        try {
            return inventarioRepository.findById(id);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al obtener el producto con ID: " + id, ex);
        }
    }

    // Guardar un producto en el inventario
    public Inventario saveInventario(Inventario inventario) {
        try {
            int idCategoria = inventario.getId_categoria();

            if (!categoriaRepository.existsById((long) idCategoria)) {
                throw new IllegalArgumentException("La categoría con ID: " + idCategoria + " no existe.");
            }

            return inventarioRepository.save(inventario);

        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al guardar el producto en el inventario", ex);
        }
    }


    // Actualizar un producto en el inventario
    public Inventario updateInventario(Long id, Inventario inventarioDetails) {
        try {
            Inventario inventario = inventarioRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));

            int idCategoria = inventarioDetails.getId_categoria();

            Long idCategoriaLong = Long.valueOf(idCategoria);

            if (!categoriaRepository.existsById(idCategoriaLong)) {
                throw new IllegalArgumentException("La categoría con ID: " + idCategoria + " no existe.");
            }

            inventario.setNombre(inventarioDetails.getNombre());
            inventario.setCantidad(inventarioDetails.getCantidad());
            inventario.setPrecio_costo(inventarioDetails.getPrecio_costo());
            inventario.setIva(inventarioDetails.getIva());
            inventario.setPrecio_venta(inventarioDetails.getPrecio_venta());
            inventario.setEan(inventarioDetails.getEan());
            inventario.setDescripcion(inventarioDetails.getDescripcion());
            inventario.setFecha_ingreso(inventarioDetails.getFecha_ingreso());
            inventario.setId_categoria(idCategoria); // Guardar idCategoria como int

            return inventarioRepository.save(inventario);

        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al actualizar el producto con ID: " + id, ex);
        }
    }

    // Eliminar un producto del inventario
    public void deleteInventario(Long id) {
        try {
            inventarioRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));
            inventarioRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al eliminar el producto con ID: " + id, ex);
        }
    }
}
