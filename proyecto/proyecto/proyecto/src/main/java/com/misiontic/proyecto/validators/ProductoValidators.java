package com.misiontic.proyecto.validators;

import com.misiontic.proyecto.entity.Producto;
import com.misiontic.proyecto.exceptions.ValidateServiceException;

public class ProductoValidators{

	public static void validador(Producto producto) {

		if (producto.getNombre() == null) {
			throw new ValidateServiceException("El nombre del producto es obligatorio.");
		}
		
		if (producto.getNombre().length() > 45) {
			throw new ValidateServiceException("El nombre del producto debe ser m�ximo de 45 caracteres.");
		}

		if (producto.getReferencia() == null) {
			throw new ValidateServiceException("La referencia es obligatoria.");
		}
		
		if (producto.getReferencia().length() > 45) {
			throw new ValidateServiceException("La referencia del producto debe ser m�ximo de 45 caracteres.");
		}
	
		
		if (producto.getCantidad() == null) {
			throw new ValidateServiceException("La cantidad del producto es obligatoria.");
		}
		
		if (producto.getCantidad() <= 0) {
			throw new ValidateServiceException("La cantidad del producto debe ser mayor a cero.");
		}
		
		if (producto.getPrecio() == null) {
			throw new ValidateServiceException("El precio del producto es obligatoria.");
		}
		
		if (producto.getPrecio() <= 0) {
			throw new ValidateServiceException("El precio del producto debe ser mayor a cero.");
		}
		
		if (producto.getExistencias() == null) {
			throw new ValidateServiceException("La existencia del producto es obligatoria.");
		}


	}

}
