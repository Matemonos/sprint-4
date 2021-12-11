package com.misiontic.proyecto.dtos;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

	private Long idProducto;
	private String nombre;
	private Long cantidad;
	private Double precio;
	private String referencia;
	private Integer existencias;

}
