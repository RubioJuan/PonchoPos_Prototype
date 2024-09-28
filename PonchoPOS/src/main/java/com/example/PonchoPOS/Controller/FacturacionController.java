package com.example.PonchoPOS.Controller;

import com.example.PonchoPOS.model.Facturacion;
import com.example.PonchoPOS.model.Factura_detalle;
import com.example.PonchoPOS.service.FacturacionService;
import com.example.PonchoPOS.service.Factura_detalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/PonchoPos/facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;

    @Autowired
    private Factura_detalleService facturaDetalleService;

    // Mostrar la lista de todas las facturas y detalles en un solo HTML
    @GetMapping
    public String getAllFacturasYDetalles(Model model) {
        List<Facturacion> facturas = facturacionService.getAllFacturas();
        model.addAttribute("facturas", facturas);

        // Agregamos un nuevo objeto factura vacío para crear una nueva factura desde el mismo formulario
        model.addAttribute("nuevaFactura", new Facturacion());

        // Agregamos un objeto para crear detalles
        model.addAttribute("nuevoDetalle", new Factura_detalle());
        
        return "facturacion"; // Retorna a la vista "facturacion.html"
    }

    // Guardar una nueva factura desde la misma página
    @PostMapping("/guardar")
    public String saveFactura(@ModelAttribute("nuevaFactura") Facturacion facturacion) {
        facturacionService.saveFactura(facturacion);
        return "redirect:/PonchoPos/facturacion"; // Redirigir a la lista de facturas
    }

    // Editar una factura existente
    @PostMapping("/actualizar/{id}")
    public String updateFactura(@PathVariable int id, @ModelAttribute("factura") Facturacion facturaDetails) {
        facturacionService.updateFactura(id, facturaDetails);
        return "redirect:/PonchoPos/facturacion";
    }

    // Eliminar una factura
    @GetMapping("/eliminar/{id}")
    public String deleteFactura(@PathVariable int id) {
        facturacionService.deleteFactura(id);
        return "redirect:/PonchoPos/facturacion"; // Redirigir a la lista de facturas
    }

    // Guardar un nuevo detalle desde la misma página
    @PostMapping("/{id}/detalles/guardar")
    public String saveDetalle(@PathVariable int id, @ModelAttribute("nuevoDetalle") Factura_detalle detalle) {
        Optional<Facturacion> facturacion = facturacionService.getFacturaById(id);

        if (facturacion.isPresent()) {
            // Asignar la factura completa al detalle
            detalle.setFacturacion(facturacion.get());

            // Guardar el detalle de factura
            facturaDetalleService.createDetalle(detalle);
        } else {
            // Si no se encuentra la factura, redirigir a la página de error o manejo
            return "redirect:/PonchoPos/facturacion?error=FacturaNoEncontrada";
        }

        return "redirect:/PonchoPos/facturacion"; // Redirigir a la página de facturación
    }


    // Eliminar un detalle de factura
    @GetMapping("/{facturaId}/detalles/eliminar/{detalleId}")
    public String deleteDetalle(@PathVariable int facturaId, @PathVariable int detalleId) {
        facturaDetalleService.deleteDetalle(detalleId);
        return "redirect:/PonchoPos/facturacion"; // Redirigir a la página de facturación
    }
}
