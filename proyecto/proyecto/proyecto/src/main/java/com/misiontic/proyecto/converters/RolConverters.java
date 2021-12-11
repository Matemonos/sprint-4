package com.misiontic.proyecto.converters;

import com.misiontic.proyecto.dtos.RolDTO;
import com.misiontic.proyecto.entity.Rol;

public class RolConverters extends AbstractConverter<Rol, RolDTO> {
	
	@Override
	public RolDTO fromEntity(Rol entity) {
		return RolDTO.builder()
				.idrol(entity.getIdrol())
				.nombre(entity.getNombre())
				.build();
	}

	@Override
	public Rol fromDTO(RolDTO dto) {
		return Rol.builder()
				.idrol(dto.getIdrol())
				.nombre(dto.getNombre())
				.build();
	}

}
