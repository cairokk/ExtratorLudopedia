package com.tcc.demo.Repository;

import com.tcc.demo.Model.JogoDetalhado;
import com.tcc.demo.Model.JogoResumido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JogoDetalhadoRepository extends JpaRepository<JogoDetalhado, Long> {

    JogoDetalhado findByJogoResumido(JogoResumido jr);
}
