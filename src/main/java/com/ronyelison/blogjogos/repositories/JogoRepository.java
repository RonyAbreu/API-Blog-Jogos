package com.ronyelison.blogjogos.repositories;

import com.ronyelison.blogjogos.models.Categoria;
import com.ronyelison.blogjogos.models.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo,String>{
}
