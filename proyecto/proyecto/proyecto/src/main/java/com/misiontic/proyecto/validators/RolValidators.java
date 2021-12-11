package com.misiontic.proyecto.validators;

import com.misiontic.proyecto.entity.Rol;
import com.misiontic.proyecto.exceptions.ValidateServiceException;

public class RolValidators{
	
	public static void validador(Rol rol) {
		
		if(rol.getNombre() == null || rol.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre del perfil es obligatorio.");
		}
		
		if(rol.getNombre().length() > 45) {
			throw new ValidateServiceException("El nombre del rol es muy largo maximo 45 caracteres.");
		}
		
	}
}
