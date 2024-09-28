package com.example.PonchoPOS.Controller;

import com.example.PonchoPOS.model.Factura_detalle;
import com.example.PonchoPOS.service.Factura_detalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/PonchoPos/facturaDetalle")
public class Factura_detalleController {

    @Autowired
    private Factura_detalleService facturaDetalleService;

    // Obtener todos los detalles de facturas
    @GetMapping
    public String getAllDetalles(Model model) {
        List<Factura_detalle> detalles = facturaDetalleService.getAllDetalles();
        model.addAttribute("detalles", detalles);  // Pasamos los detalles al modelo para la vista
        return "facturacion";  // Retornamos a la vista facturacion.html
    }

    // Obtener un detalle de factura por ID
    @GetMapping("/{id}")
    public String getDetalleById(@PathVariable int id, Model model) {
        Optional<Factura_detalle> detalle = facturaDetalleService.getDetalleById(id);
        if (detalle.isPresent()) {
            model.addAttribute("detalle", detalle.get());  // Pasamos el detalle encontrado a la vista
        } else {
            model.addAttribute("error", "Detalle no encontrado");
        }
        return "facturacion";  // Retornamos a la vista facturacion.html
    }

    // Crear un nuevo detalle de factura
    @PostMapping("/guardar")
    public String createDetalle(@ModelAttribute("nuevoDetalle") Factura_detalle facturaDetalle, Model model) {
        facturaDetalleService.createDetalle(facturaDetalle);
        return "redirect:/PonchoPos/facturaDetalle";  // Redirigimos a la página principal de facturacion
    }

    // Actualizar un detalle de factura
    @PostMapping("/actualizar/{id}")
    public String updateDetalle(@PathVariable int id, @ModelAttribute("detalle") Factura_detalle detalleDetails, Model model) {
        facturaDetalleService.updateDetalle(id, detalleDetails);
        return "redirect:/PonchoPos/facturaDetalle";  // Redirigimos a la página principal de facturacion
    }

    // Eliminar un detalle de factura
    @GetMapping("/eliminar/{id}")
    public String deleteDetalle(@PathVariable int id) {
        facturaDetalleService.deleteDetalle(id);
        return "redirect:/PonchoPos/facturaDetalle";  // Redirigimos a la página principal de facturacion
    }
}
