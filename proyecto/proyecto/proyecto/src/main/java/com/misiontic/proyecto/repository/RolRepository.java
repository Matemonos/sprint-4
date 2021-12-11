package com.misiontic.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.proyecto.entity.Rol;



@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
