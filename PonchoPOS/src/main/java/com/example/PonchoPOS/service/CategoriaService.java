package com.example.PonchoPOS.service;

import com.example.PonchoPOS.model.Categoria;
import com.example.PonchoPOS.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //Obtener todas las categorias
    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }

    //Registras Categorias
    public Categoria saveCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    
}
