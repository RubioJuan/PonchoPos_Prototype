package com.example.PonchoPOS.Controller;

import com.example.PonchoPOS.model.Categoria;
import com.example.PonchoPOS.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/PonchoPos/Categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Mostrar todas las categorías y redirigir a categorias.html
    @GetMapping
    public String getAllCategoria(Model model) {
        List<Categoria> categorias = categoriaService.getAllCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoria", new Categoria()); // Para el formulario
        return "categorias";  // Redirige a la vista categorias.html
    }

    // Mostrar una categoría por ID (puedes mostrarlo en una página dedicada si lo necesitas)
    @GetMapping("/{id}")
    public String getCategoriaById(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.getCategoryByID(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con ID: " + id));
        model.addAttribute("categoria", categoria);
        return "categoriaDetalle";  // Aquí podrías tener una vista para mostrar los detalles de la categoría
    }

    // Formulario para crear una nueva categoría
    @GetMapping("/crear")
    public String crearCategoriaForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias";  // Muestra categorias.html con el formulario incluido
    }

    // Crear una categoría y redirigir al index
    @PostMapping
    public String createCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.saveCategoria(categoria);
        return "redirect:/PonchoPos/Categoria";  // Redirige a la lista de categorías después de guardar
    }

    // Formulario para actualizar una categoría existente
    @GetMapping("/editar/{id}")
    public String editarCategoriaForm(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.getCategoryByID(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con ID: " + id));
        model.addAttribute("categoria", categoria);
        return "categorias";  // Usamos categorias.html para editar, asegurando que tenga el formulario
    }

    // Actualizar una categoría
    @PostMapping("/editar/{id}")
    public String updateCategoria(@PathVariable Long id, @ModelAttribute Categoria categoriaDetails) {
        categoriaService.updateCategoria(id, categoriaDetails);
        return "redirect:/PonchoPos/Categoria";  // Redirige a la lista de categorías después de actualizar
    }

    // Eliminar una categoría
    @GetMapping("/eliminar/{id}")
    public String deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return "redirect:/PonchoPos/Categoria";  // Redirige a la lista de categorías después de eliminar
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleNotFound(IllegalArgumentException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "error";  // Redirige a una página de error
    }
}
    