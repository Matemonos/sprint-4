package com.misiontic.proyecto.validators;

import com.misiontic.proyecto.entity.Compra;
import com.misiontic.proyecto.exceptions.ValidateServiceException;


public class CompraValidators {
	public static void validador(Compra compra) {

		if (compra.getIdCliente() == null) {
			throw new ValidateServiceException("El idcliente es obligatorio.");
		}

		if (compra.getFecha() == null) {
			throw new ValidateServiceException("La fecha es obligatoria.");
		}

		if (compra.getTotal() == null) {
			throw new ValidateServiceException("El total es obligatorio.");
		}

	}
}
