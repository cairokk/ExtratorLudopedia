package com.tcc.demo.Repository;

import com.tcc.demo.Model.Mecanica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MecanicaRepository extends JpaRepository<Mecanica, Long> {
    Mecanica findByIdExterno(Long idJogo);

}
