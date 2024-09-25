package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Inventario;
import com.example.PonchoPOS.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    //Obtener inventario
    public List<Inventario> getAllInventario(){
        return inventarioRepository.findAll();
    }

    // Obtener por id inventario
    public Optional<Inventario> getInventarioById(Long id){
        return inventarioRepository.findById(id);
    }
}
