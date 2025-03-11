package com.tcc.demo.Repository;

import com.tcc.demo.Model.JogoResumido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Repository
public interface JogoResumidoRepository extends JpaRepository<JogoResumido, Long> {
    JogoResumido findByIdExterno(Long idJogo);

    List<JogoResumido> findByDetalhadoFalse();

    Page<JogoResumido> findByDetalhadoFalse(Pageable pageable);
}
