package com.ronyelison.blogjogos.repositories;

import com.ronyelison.blogjogos.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,String>{
}
