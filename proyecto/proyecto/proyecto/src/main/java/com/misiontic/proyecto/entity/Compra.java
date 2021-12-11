package com.misiontic.proyecto.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
@Entity
@Table(name = "compra")
public class Compra {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id_compra", nullable=false)
		private Long idCompra;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="id_usuario", nullable=false, updatable=false, referencedColumnName="id_usuario")
		private Usuario idCliente;
		
		@Column(name="fecha", nullable=false)
		private LocalDate fecha;
		
		@Column(name="Total", nullable=false)
		private Double total;
		
		
		//@OneToMany(mappedBy = "id_compra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		//private List<detalle_compra> listaPedidos;

}
