package com.ejercicioeldar.api.repository;

import com.ejercicioeldar.api.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
    Tarjeta findByMarca(String marca);
}
