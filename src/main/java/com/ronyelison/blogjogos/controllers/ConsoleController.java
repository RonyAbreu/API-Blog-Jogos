package com.ronyelison.blogjogos.controllers;

import com.ronyelison.blogjogos.models.Console;
import com.ronyelison.blogjogos.services.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleController {
    private ConsoleService service;

    @Autowired
    public ConsoleController(ConsoleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Console> addConsole(@RequestBody Console console){
        return ResponseEntity.ok(service.addConsole(console));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Console> findById(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Console>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
