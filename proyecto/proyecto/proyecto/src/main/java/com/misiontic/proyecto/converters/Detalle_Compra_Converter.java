package com.misiontic.proyecto.converters;

import com.misiontic.proyecto.dtos.Detalle_Compra_DTO;
import com.misiontic.proyecto.entity.Detalle_Compra;

public class Detalle_Compra_Converter extends AbstractConverter<Detalle_Compra, Detalle_Compra_DTO> {

	@Override
	public Detalle_Compra_DTO fromEntity(Detalle_Compra entity) {
		return Detalle_Compra_DTO.builder()
				.id_detalle(entity.getId_detalle())
				.id_producto(entity.getId_producto())
				.id_compra(entity.getId_compra())
				.cantidad(entity.getCantidad())
				.total(entity.getTotal())
				.build();
	}

	@Override
	public Detalle_Compra fromDTO(Detalle_Compra_DTO dto) {
		return Detalle_Compra.builder()
				.id_detalle(dto.getId_detalle())
				.id_producto(dto.getId_producto())
				.id_compra(dto.getId_compra())
				.cantidad(dto.getCantidad())
				.total(dto.getTotal())
				.build();
	}

}
