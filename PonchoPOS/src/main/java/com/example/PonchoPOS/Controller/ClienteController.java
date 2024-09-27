package com.example.PonchoPOS.Controller;

import com.example.PonchoPOS.model.Clientes;
import com.example.PonchoPOS.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/PonchoPos/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Mostrar todos los clientes
    @GetMapping
    public String getAllClientes(Model model) {
        List<Clientes> clientes = clienteService.getAllClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new Clientes()); // Inicializa un nuevo cliente para el formulario
        return "clientes"; // Asegúrate de que la vista "clientes.html" esté en la carpeta correcta
    }

    // Formulario para actualizar un cliente existente
    @GetMapping("/editar/{id}")
    public String editarClienteForm(@PathVariable int id, Model model) {
        Clientes cliente = clienteService.getClienteByID(id);
        model.addAttribute("cliente", cliente);
        return "clientes";  // Asegúrate de que la vista "clientes.html" esté configurada correctamente para editar
    }

    // Actualizar un cliente
    @PostMapping("/editar/{id}")
    public String updateCliente(@PathVariable int id, @ModelAttribute Clientes clientesDetails) {
        clienteService.updateCliente(id, clientesDetails);
        return "redirect:/PonchoPos/Cliente"; // Redirige a la lista de clientes después de actualizar
    }

    // Crear un cliente
    @PostMapping
    public String crearClienteForm(@ModelAttribute Clientes clientes) {
        clienteService.saveCliente(clientes);// Para el formulario de creación
        return "redirect:/PonchoPos/Cliente"; // Muestra la vista de clientes
    }

    // Eliminar un cliente
    @GetMapping("/eliminar/{id}")
    public String deleteCliente(@PathVariable int id) {
        clienteService.deleteCliente(id);
        return "redirect:/PonchoPos/Cliente"; // Redirige a la lista de clientes
    }
}
