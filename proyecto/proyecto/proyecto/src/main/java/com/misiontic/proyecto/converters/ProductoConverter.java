package com.misiontic.proyecto.converters;

import com.misiontic.proyecto.dtos.ProductoDTO;
import com.misiontic.proyecto.entity.Producto;

public class ProductoConverter extends AbstractConverter<Producto, ProductoDTO>{

	@Override
	public ProductoDTO fromEntity(Producto entity) {
		return ProductoDTO.builder()
				.idProducto(entity.getIdProducto())
				.nombre(entity.getNombre())
				.cantidad(entity.getCantidad())
				.precio(entity.getPrecio())
				.referencia(entity.getReferencia())
				.existencias(entity.getExistencias())
				.build();
	}
	
	@Override
	public Producto fromDTO(ProductoDTO dto) {
		return Producto.builder()
				.idProducto(dto.getIdProducto())
				.nombre(dto.getNombre())
				.cantidad(dto.getCantidad())
				.precio(dto.getPrecio())
				.referencia(dto.getReferencia())
				.existencias(dto.getExistencias())
				.build();
	}

}
