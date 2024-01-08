package com.ronyelison.blogjogos.services;

import com.ronyelison.blogjogos.models.Categoria;
import com.ronyelison.blogjogos.models.Console;
import com.ronyelison.blogjogos.models.Jogo;
import com.ronyelison.blogjogos.repositories.CategoriaRepository;
import com.ronyelison.blogjogos.repositories.ConsoleRepository;
import com.ronyelison.blogjogos.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {
    private JogoRepository jogoRepository;
    private ConsoleRepository consoleRepository;
    private CategoriaRepository categoriaRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository, ConsoleRepository consoleRepository, CategoriaRepository categoriaRepository) {
        this.jogoRepository = jogoRepository;
        this.consoleRepository = consoleRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Jogo addJogo(Jogo jogo){
        Jogo jogoParaAdicionar = new Jogo(jogo.getNome(),jogo.getDescricao(),jogo.getUrlDaImagem());
        return jogoRepository.save(jogoParaAdicionar);
    }

    public Jogo findById(String id){
        return jogoRepository.findById(id).get();
    }

    public List<Jogo> findAll(){
        return jogoRepository.findAll();
    }

    public Jogo addConsole(String idJogo, String idConsole){
        Optional<Jogo> jogoRetornado = jogoRepository.findById(idJogo);
        Optional<Console> consoleOptional = consoleRepository.findById(idConsole);

        if (jogoRetornado.isEmpty() || consoleOptional.isEmpty()){
            throw new RuntimeException("Jogo ou Console não existe!");
        }

        jogoRetornado.get().addConsole(consoleOptional.get());
        return jogoRepository.save(jogoRetornado.get());
    }

    public Jogo addCategoria(String idJogo, String idCategoria){
        Optional<Jogo> jogoRetornado = jogoRepository.findById(idJogo);
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCategoria);

        if (jogoRetornado.isEmpty() || categoriaOptional.isEmpty()){
            throw new RuntimeException("Jogo ou Categoria não existe!");
        }

        jogoRetornado.get().addCategoria(categoriaOptional.get());
        return jogoRepository.save(jogoRetornado.get());
    }
}

