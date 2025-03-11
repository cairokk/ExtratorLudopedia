package com.tcc.demo.Repository;

import com.tcc.demo.Model.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByIdExterno(Long idJogo);
}
