package com.misiontic.proyecto.converters;

import com.misiontic.proyecto.dtos.CompraDTO;
import com.misiontic.proyecto.entity.Compra;

public class CompraConverter extends AbstractConverter<Compra, CompraDTO>{

	@Override
	public CompraDTO fromEntity(Compra entity) {
		return CompraDTO.builder()
				.id_compra(entity.getIdCompra())
				.id_usuario(entity.getIdCliente())
				.fecha(entity.getFecha())
				.total(entity.getTotal())
				.build();
	}

	@Override
	public Compra fromDTO(CompraDTO dto) {
		return Compra.builder()
				.idCompra(dto.getId_compra())
				.idCliente(dto.getId_usuario())
				.fecha(dto.getFecha())
				.total(dto.getTotal())
				.build();
	}

}
