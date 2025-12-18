package com.projeto.Carros.repositorios;

import com.projeto.Carros.entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRespository
        extends JpaRepository<Carro, Long> {


}
