package com.ronyelison.blogjogos.services;

import com.ronyelison.blogjogos.models.Categoria;
import com.ronyelison.blogjogos.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private CategoriaRepository repository;

    @Autowired
    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria addCategoria(Categoria categoria){
        return repository.save(categoria);
    }

    public Categoria findById(String uuid){
        return repository.findById(uuid).get();
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }
}
