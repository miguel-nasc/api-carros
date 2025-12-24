package com.projeto.Carros.repositorios;

import com.projeto.Carros.dtos.CarroDTO;
import com.projeto.Carros.entidades.Carro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository
        extends JpaRepository<Carro, Long> {

    @Query("SELECT c FROM Carro c WHERE c.modelo = :modelo")
    Page<Carro> findByModelo(@Param(value = "modelo") String modelo, Pageable pageable);

    @Query("SELECT c FROM Carro c WHERE c.modelo = :cor")
    Page<Carro> findByCor(@Param(value = "cor") String cor, Pageable pageable);

    @Query("SELECT c FROM Carro c WHERE c.ano = :ano")
    Page<Carro> findByYear(@Param(value = "ano") String ano, Pageable pageable);

    @Query("SELECT c FROM Carro c WHERE c.motorizacao = :motorizacao")
    Page<Carro> findByMotorizacao(@Param(value = "motorizacao") String motorizacao, Pageable pageable);


}
