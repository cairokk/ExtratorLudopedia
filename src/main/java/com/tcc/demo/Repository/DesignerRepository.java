package com.tcc.demo.Repository;


import com.tcc.demo.Model.Designer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DesignerRepository extends JpaRepository<Designer, Long> {
    Designer findByIdExterno(Long idJogo);
}
