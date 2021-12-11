package com.misiontic.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rol")
public class Rol {
	@Id
	@Column(name = "id_rol", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrol;

	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;

}
