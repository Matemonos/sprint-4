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

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false)
	private Long id_usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rol", nullable = false, updatable = false, referencedColumnName = "id_rol")
	private Rol id_rol;
	
	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 45, nullable = false)
	private String apellido;
	
	@Column(name = "telefono", length = 45, nullable = false)
	private String telefono;
	
	@Column(name = "nombre_usuario", length = 45, nullable = true)
	private String nombreusuario;
	
	@Column(name = "clave", length = 45, nullable = true)
	private String clave;
	
	//@OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private List<compra> listaPedidosCliente;


}
