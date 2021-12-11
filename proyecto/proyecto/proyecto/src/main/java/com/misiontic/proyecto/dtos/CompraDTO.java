package com.misiontic.proyecto.dtos;

import java.time.LocalDate;

import com.misiontic.proyecto.entity.Usuario;

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
public class CompraDTO {
	
	private Long id_compra;
	private Usuario id_usuario;
	private LocalDate fecha;
	private Double total;

}
