package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Clientes;
import com.example.PonchoPOS.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    // Aañadir clientes
    public Clientes agregarCliente(Clientes cliente) {
        try {
            return clientesRepository.save(cliente);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar el cliente: " + e.getMessage());
        }
    }

    // Buscar por cliente nombre
    public List<Clientes> buscarClientePorNombre(String nombre) {
        try {
            return clientesRepository.findByNombreContainingIgnoreCase(nombre);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar cliente por nombre: " + e.getMessage());
        }
    }

    // Buscar cliente por ID
    public Optional<Clientes> buscarClientePorId(Integer id) {
        try {
            return clientesRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar cliente por ID: " + e.getMessage());
        }
    }

    // Editar cliente
    public Clientes editarCliente(Clientes cliente) {
        try {
            if (clientesRepository.existsById(cliente.getId_cliente())) {
                return clientesRepository.save(cliente);
            } else {
                throw new RuntimeException("Cliente no encontrado para editar");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al editar el cliente: " + e.getMessage());
        }
    }

    // Borrar cliente
    public void borrarClientePorId(Integer id) {
        try {
            if (clientesRepository.existsById(id)) {
                clientesRepository.deleteById(id);
            } else {
                throw new RuntimeException("Cliente no encontrado para eliminar");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar el cliente: " + e.getMessage());
        }
    }
}
