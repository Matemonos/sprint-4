package com.misiontic.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.proyecto.converters.RolConverters;
import com.misiontic.proyecto.dtos.RolDTO;
import com.misiontic.proyecto.entity.Rol;
import com.misiontic.proyecto.services.RolServices;
import com.misiontic.proyecto.utils.WrapperResponse;


@RestController
@CrossOrigin(origins = "*")
public class RolControllers {
	@Autowired
	private RolServices rolService;
	private RolConverters converter = new RolConverters();
	
	
	@GetMapping(value="/roles")
	public ResponseEntity<WrapperResponse<List<RolDTO>>> findAll(){
		List<Rol> arregloRol = rolService.findAll();
		List<RolDTO> arregloRolDto = converter.fromEntity(arregloRol);
		return new WrapperResponse<>(true, "success", arregloRolDto).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value="/roles/{rolId}")
	public ResponseEntity<WrapperResponse<RolDTO>> findById(@PathVariable("rolId") Long rolId) {
		Rol objrol = rolService.findById(rolId);
		RolDTO objRolDto = converter.fromEntity(objrol);
		return new WrapperResponse<>(true, "success", objRolDto).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/roles")
	public ResponseEntity<WrapperResponse<RolDTO>> create(@RequestBody RolDTO rol) {
		Rol nuevorol = rolService.create(converter.fromDTO(rol));
		RolDTO objRolDto = converter.fromEntity(nuevorol);
		return new WrapperResponse<>(true, "success", objRolDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/roles")
	public ResponseEntity<WrapperResponse<RolDTO>> update(@RequestBody RolDTO rol) {
		Rol objrol = rolService.update(converter.fromDTO(rol));
		RolDTO objRolDto = converter.fromEntity(objrol);
		return new WrapperResponse<>(true, "success", objRolDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/roles/{rolId}")
	public ResponseEntity<?> delete(@PathVariable("rolId") Long rolId) {
		rolService.delete(rolId);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	}
	

}
