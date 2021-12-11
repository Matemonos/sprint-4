package com.misiontic.proyecto.converters;

import com.misiontic.proyecto.dtos.UsuarioDTO;
import com.misiontic.proyecto.entity.Usuario;

public class UsuarioConverter extends AbstractConverter<Usuario, UsuarioDTO>{

	@Override
	public UsuarioDTO fromEntity(Usuario entity) {
		return UsuarioDTO.builder()
				.id_usuario(entity.getId_usuario())
				.id_rol(entity.getId_rol())
				.nombre(entity.getNombre())
				.apellido(entity.getApellido())
				.telefono(entity.getTelefono())
				.nombre_usuario(entity.getNombreusuario())
				.clave(entity.getClave())
				.build();
	}

	@Override
	public Usuario fromDTO(UsuarioDTO dto) {
		return Usuario.builder()
				.id_usuario(dto.getId_usuario())
				.id_rol(dto.getId_rol())
				.nombre(dto.getNombre())
				.apellido(dto.getApellido())
				.telefono(dto.getTelefono())
				.nombreusuario(dto.getNombre_usuario())
				.clave(dto.getClave())
				.build();
	}

}
