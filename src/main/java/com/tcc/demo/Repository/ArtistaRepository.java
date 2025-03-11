package com.tcc.demo.Repository;

import com.tcc.demo.Model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Artista findByIdExterno(Long idJogo);
}
