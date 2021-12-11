package com.misiontic.proyecto.dtos;



import com.misiontic.proyecto.entity.Rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

	private Long id_usuario;
	private Rol id_rol;
	private String nombre;
	private String apellido;
	private String telefono;
	private String nombre_usuario;
	private String clave;

	}

