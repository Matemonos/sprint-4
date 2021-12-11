package com.misiontic.proyecto.entity;

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

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name="detalle_compra")
public class Detalle_Compra {
	
	@Id
	@Column(name="id_detalle", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_detalle;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_producto", nullable = false, updatable = false, referencedColumnName = "id_producto")
	private Producto id_producto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_compra", nullable = false, updatable = false, referencedColumnName = "id_compra")
	private Compra id_compra;
	
	@Column(name="cantidad",  nullable = false)
	private Integer cantidad;
	
	@Column(name="total",  nullable = false)
	private Double total;

}
