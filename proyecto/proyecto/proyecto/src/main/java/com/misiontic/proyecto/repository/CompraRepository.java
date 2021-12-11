package com.misiontic.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.proyecto.entity.Compra;



@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
