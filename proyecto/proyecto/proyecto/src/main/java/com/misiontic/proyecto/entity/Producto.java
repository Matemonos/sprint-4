package com.misiontic.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto", nullable = false)
	private Long idProducto;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@Column(name = "cantidad", nullable = false)
	private Long cantidad;
	
	@Column(name = "Precio", nullable = false)
	private Double precio;
	
	@Column(name = "referencia", nullable = false, length= 45)
	private String referencia;
	
	@Column(name = "existencias", nullable = false)
	private Integer existencias;
	
	//@OneToMany(mappedBy = "id_Producto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		//private List<Detalle_compra> listaProductos;
}
