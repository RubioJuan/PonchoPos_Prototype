package com.example.PonchoPOS.Controller;

import com.example.PonchoPOS.model.Clientes;
import com.example.PonchoPOS.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PonchoPos/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Obtener todos los clientes
    @GetMapping
    public List<Clientes> getAllClientes() {
        return clienteService.getAllClientes();
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public Clientes getClienteById(@PathVariable int id) {
        return clienteService.getClienteByID(id); // Cambiado a int, no se necesita Optional
    }

    // Crear un cliente
    @PostMapping
    public Clientes createCliente(@RequestBody Clientes clientes) {
        return clienteService.saveCliente(clientes);
    }

    // Actualizar un cliente
    @PutMapping("/{id}")
    public Clientes updateCliente(@PathVariable int id, @RequestBody Clientes clientesDetails) {
        return clienteService.updateCliente(id, clientesDetails);
    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable int id) {
        clienteService.deleteCliente(id);
    }

    // Manejar excepciones
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleNotFound(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}
