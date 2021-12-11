package com.misiontic.proyecto.validators;

import com.misiontic.proyecto.entity.Usuario;
import com.misiontic.proyecto.exceptions.ValidateServiceException;

public class UsuarioValidators {
	public static void Validador(Usuario usuario) {
		
		if(usuario.getId_rol() == null) {
			throw new ValidateServiceException("El rol del usuario es obligatorio");
		}
		
		
		if(usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre del usuario es obligatorio");
		}
		
		if(usuario.getApellido() == null || usuario.getApellido().trim().isEmpty()) {
			throw new ValidateServiceException("los apellidos del usuario es obligatorio");
		}
		
		if(usuario.getNombreusuario() == null || usuario.getNombreusuario().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre del usuario es obligatorio");
		}
		
		if(usuario.getClave() == null || usuario.getClave().trim().isEmpty()) {
			throw new ValidateServiceException("La clave del usuario es obligatoria");
		}
		
		if(usuario.getNombre().length() > 45) {
			throw new ValidateServiceException("El nombre del usuario debe ser menor a 45 caracteres");
		}
		
		if(usuario.getApellido().length() > 45) {
			throw new ValidateServiceException("Los apellidos del usuario debe ser menor a 45 caracteres");
		}
		
		if(usuario.getNombreusuario().length() > 45) {
			throw new ValidateServiceException("El nombre del usuario debe ser menor a 45 caracteres");
		}
		
		if(usuario.getClave().length() > 45) {
			throw new ValidateServiceException("La clave del usuario es menor a 100 caracteres");
		}
		
	}

}
