package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Clientes;
import com.example.PonchoPOS.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;

    // Obtener todos los clientes
    public List<Clientes> getAllClientes() {
        try {
            return clientesRepository.findAll();
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al obtener los clientes", ex);
        }
    }

    // Obtener un cliente por ID
    public Clientes getClienteByID(int id) {
        try {
            return clientesRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + id));
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al obtener el cliente con ID: " + id, ex);
        }
    }

    // Guardar un cliente
    public Clientes saveCliente(Clientes clientes) {
        try {
            // Validar que los campos requeridos no sean nulos
            if (clientes.getNombre() == null || clientes.getNombre().isEmpty()) {
                throw new IllegalArgumentException("El nombre del cliente es obligatorio");
            }
            // Otras validaciones según sea necesario

            return clientesRepository.save(clientes);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al guardar el cliente", ex);
        }
    }

    // Actualizar un cliente
    public Clientes updateCliente(int id, Clientes clientesDetails) {
        try {
            Clientes cliente = clientesRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + id));
            cliente.setNombre(clientesDetails.getNombre());
            cliente.setDireccion(clientesDetails.getDireccion());
            cliente.setTelefono(clientesDetails.getTelefono());
            // Agrega otras actualizaciones según sea necesario
            return clientesRepository.save(cliente);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al actualizar el cliente con ID: " + id, ex);
        }
    }

    // Eliminar un cliente
    public void deleteCliente(int id) {
        try {
            clientesRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + id));
            clientesRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al eliminar el cliente con ID: " + id, ex);
        }
    }
}
