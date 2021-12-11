package com.misiontic.proyecto.validators;

import com.misiontic.proyecto.entity.Detalle_Compra;
import com.misiontic.proyecto.exceptions.ValidateServiceException;

public class Detalle_Compra_Validators {
	public static void detalle_compraValidador(Detalle_Compra detalle_compra) {
		if (detalle_compra.getId_producto() == null) {
			throw new RuntimeException("El id del producto es obligatorio.");
		}
		
		if (detalle_compra.getId_compra() == null) {
			throw new RuntimeException("El id de compra es obligatorio.");
		}
		
		if (detalle_compra.getCantidad() < 0) {
			throw new RuntimeException("La cantidad del producto debe ser mayor a 0.");
		}
		
		if (detalle_compra.getTotal() < 0) {
			throw new RuntimeException("El Total debe ser mayor a 0.");
		}
		
		if (detalle_compra.getCantidad() == null) {
			throw new ValidateServiceException("La cantidad del producto es obligatoria.");
		}
		
		if (detalle_compra.getTotal() == null) {
			throw new ValidateServiceException("El total del producto es obligatorio.");
		}
	}
}
