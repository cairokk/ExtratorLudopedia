package com.tcc.demo.Repository;

import com.tcc.demo.Model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
    Tema findByIdExterno(Long idJogo);
}
