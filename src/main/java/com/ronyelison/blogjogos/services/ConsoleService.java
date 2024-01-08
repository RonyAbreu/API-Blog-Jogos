package com.ronyelison.blogjogos.services;

import com.ronyelison.blogjogos.models.Console;
import com.ronyelison.blogjogos.repositories.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleService {
    private ConsoleRepository repository;

    @Autowired
    public ConsoleService(ConsoleRepository repository) {
        this.repository = repository;
    }

    public Console addConsole(Console console){
        return repository.save(console);
    }

    public Console findById(String uuid){
        return repository.findById(uuid).get();
    }

    public List<Console> findAll(){
        return repository.findAll();
    }
}
