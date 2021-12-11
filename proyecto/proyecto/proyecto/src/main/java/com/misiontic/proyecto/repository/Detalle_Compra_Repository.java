package com.misiontic.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.proyecto.entity.Detalle_Compra;



@Repository
public interface Detalle_Compra_Repository extends JpaRepository<Detalle_Compra, Long> {
}
