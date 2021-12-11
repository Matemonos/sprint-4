package com.misiontic.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.proyecto.entity.Producto;



@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
