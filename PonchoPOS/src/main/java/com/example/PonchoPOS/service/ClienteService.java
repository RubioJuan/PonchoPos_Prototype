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
            Map<String, String> camposTexto = new HashMap<>();
            camposTexto.put("Documento", clientes.getDocumento());
            camposTexto.put("Nombre", clientes.getNombre());
            camposTexto.put("Apellido", clientes.getApellido());
            camposTexto.put("Pais", clientes.getPais());
            camposTexto.put("Ciudad", clientes.getCiudad());
            camposTexto.put("Email", clientes.getEmail());
            camposTexto.put("Teléfono", clientes.getTelefono());
            camposTexto.put("Dirección", clientes.getDireccion());
    
            // Verificar campos de texto
            for (Map.Entry<String, String> campo : camposTexto.entrySet()) {
                if (campo.getValue() == null || campo.getValue().isEmpty()) {
                    throw new IllegalArgumentException("El " + campo.getKey() + " del cliente es obligatorio");
                }
            }
    
            // Verificar fecha de nacimiento
            if (clientes.getFecha_nacimiento() == null) {
                throw new IllegalArgumentException("La fecha de nacimiento del cliente es obligatoria");
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
