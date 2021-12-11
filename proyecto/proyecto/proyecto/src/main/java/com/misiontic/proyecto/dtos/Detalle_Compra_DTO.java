package com.misiontic.proyecto.dtos;



import com.misiontic.proyecto.entity.Compra;
import com.misiontic.proyecto.entity.Producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Detalle_Compra_DTO {

	private Long id_detalle;
	private Producto id_producto;
	private Compra id_compra;
	private Integer cantidad;
	private Double total;

}
