package com.example.PonchoPOS.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.PonchoPOS.model.Inventario;
import com.example.PonchoPOS.service.InventarioService;

@Controller
@RequestMapping("/PonchoPos/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // Obtener todos los productos del inventario y enviar a la vista "productos"
    @GetMapping
    public String getAllInventarios(Model model) {
        List<Inventario> inventarios = inventarioService.getAllInventarios();
        model.addAttribute("inventarios", inventarios);
        model.addAttribute("inventario", new Inventario());  // Inicializar un nuevo objeto Inventario para el formulario
        return "productos";  // Retorna el archivo productos.html
    }

    // Mostrar el formulario para agregar un nuevo producto
    @GetMapping("/crear")
    public String showCreateForm(Model model) {
        model.addAttribute("inventario", new Inventario());  // Crear un nuevo objeto Inventario
        return "productos";  // Retorna el archivo productos.html
    }

    // Crear un nuevo producto en el inventario
    @PostMapping
    public String createInventario(@ModelAttribute Inventario inventario) {
        inventarioService.saveInventario(inventario);
        return "redirect:/PonchoPos/inventario";  // Redirige a la página principal del inventario
    }


    // Obtener un producto del inventario por ID y mostrar detalles en una vista
    @GetMapping("/{id}")
    public String getInventarioById(@PathVariable Long id, Model model) {       
        Optional<Inventario> inventario = inventarioService.getInventarioById(id);
        if (inventario.isPresent()) {
            model.addAttribute("inventario", inventario.get());
            return "productos";  // Retorna el archivo productos.html para mostrar los detalles
        } else {
            return "error";  // Si el producto no existe, redirige a una página de error o similar
        }
    }

    // Mostrar el formulario de edición de un producto existente
    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Inventario> inventario = inventarioService.getInventarioById(id);
        if (inventario.isPresent()) {
            model.addAttribute("inventario", inventario.get());
            return "productos";  // Retorna el archivo productos.html para mostrar el formulario de edición
        } else {
            return "error";  // Si el producto no existe, redirige a una página de error o similar
        }
    }

    // Actualizar un producto en el inventario
    @PostMapping("/actualizar/{id}")
    public String updateInventario(@PathVariable Long id, @ModelAttribute Inventario inventarioDetails) {
        inventarioService.updateInventario(id, inventarioDetails);
        return "redirect:/PonchoPos/inventario";  // Redirige a la página principal del inventario
    }

    // Eliminar un producto del inventario
    @GetMapping("/eliminar/{id}")
    public String deleteInventario(@PathVariable Long id) {
        inventarioService.deleteInventario(id);
        return "redirect:/PonchoPos/inventario";  // Redirige a la página principal del inventario
    }
}
