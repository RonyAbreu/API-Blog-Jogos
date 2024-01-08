package com.ronyelison.blogjogos.controllers;

import com.ronyelison.blogjogos.models.Jogo;
import com.ronyelison.blogjogos.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    private JogoService service;

    @Autowired
    public JogoController(JogoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Jogo> addJogo(@RequestBody Jogo jogo){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addJogo(jogo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> findById(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PatchMapping("/{idJogo}/console/{idConsole}")
    public ResponseEntity<Jogo> addConsole(@PathVariable String idJogo, @PathVariable String idConsole){
        return ResponseEntity.ok(service.addConsole(idJogo,idConsole));
    }

    @PatchMapping("/{idJogo}/categoria/{idCategoria}")
    public ResponseEntity<Jogo> addCategoria(@PathVariable String idJogo, @PathVariable String idCategoria){
        return ResponseEntity.ok(service.addCategoria(idJogo,idCategoria));
    }
}
