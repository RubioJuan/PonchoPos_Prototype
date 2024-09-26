package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Clientes;
import com.example.PonchoPOS.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<String, String> campos = new HashMap<>();
            campos.put("Documento", clientes.getDocumento());
            campos.put("Nombre", clientes.getNombre());
            campos.put("Apellido", clientes.getApellido());
            campos.put("Pais", clientes.getPais());
            campos.put("Ciudad", clientes.getCiudad());
            campos.put("Email", clientes.getEmail());
            campos.put("Teléfono", clientes.getTelefono());
            campos.put("Dirección", clientes.getDireccion());
            campos.put("Fecha de nacimiento", clientes.getFecha_nacimiento());

            for (Map.Entry<String, String> campo : campos.entrySet()) {
                if (campo.getValue() == null || campo.getValue().isEmpty()) {
                    throw new IllegalArgumentException("El " + campo.getKey() + " del cliente es obligatorio");
                }
            }
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
            cliente.setDocumento(clientesDetails.getDocumento());
            cliente.setNombre(clientesDetails.getNombre());
            cliente.setApellido(clientesDetails.getApellido());
            cliente.setPais(clientesDetails.getPais());
            cliente.setCiudad(clientesDetails.getCiudad());
            cliente.setEmail(clientesDetails.getEmail());
            cliente.setTelefono(clientesDetails.getTelefono());
            cliente.setDireccion(clientesDetails.getDireccion());
            cliente.setFecha_nacimiento(clientesDetails.getFecha_nacimiento());
            cliente.setEstado(clientesDetails.isEstado());
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
