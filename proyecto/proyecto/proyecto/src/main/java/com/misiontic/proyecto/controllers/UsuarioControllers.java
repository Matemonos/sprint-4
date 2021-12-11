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

import com.misiontic.proyecto.converters.UsuarioConverter;
import com.misiontic.proyecto.dtos.LoginRequestDTO;
import com.misiontic.proyecto.dtos.LoginResponseDTO;
import com.misiontic.proyecto.dtos.UsuarioDTO;
import com.misiontic.proyecto.entity.Usuario;
import com.misiontic.proyecto.services.UsuarioServices;
import com.misiontic.proyecto.utils.WrapperResponse;



@RestController
@CrossOrigin(origins = "*") 
public class UsuarioControllers {
	
	@Autowired
	private UsuarioServices usuarioServi;
	private UsuarioConverter converter = new UsuarioConverter();

	@GetMapping(value="/usuario")
	public ResponseEntity<WrapperResponse<List<UsuarioDTO>>> findAll(){
		
		List<Usuario> ListaUsuarios = usuarioServi.findAll();
		
		List<UsuarioDTO> arregloUsuariosDto = converter.fromEntity(ListaUsuarios);
		
		return new WrapperResponse<>(true, "success", arregloUsuariosDto).createResponse(HttpStatus.OK);
	
	}

	
	@GetMapping(value="/usuario/{usuarioId}")
	public ResponseEntity<WrapperResponse<UsuarioDTO>> findById(@PathVariable("usuarioId") Long usuarioId) {
		Usuario objUsuario = usuarioServi.findById(usuarioId);
		
		UsuarioDTO objUsuarioDto = converter.fromEntity(objUsuario);
		
		return new WrapperResponse<>(true, "success", objUsuarioDto).createResponse(HttpStatus.OK);

	}
	
	
	
	
	@PostMapping(value="/usuario")
	public ResponseEntity<WrapperResponse<UsuarioDTO>> Create(@RequestBody Usuario usuario) {
		Usuario objUsuario = usuarioServi.Create(usuario);	
		
		UsuarioDTO objUsuariosDto = converter.fromEntity(objUsuario);
		
		return new WrapperResponse<>(true, "success", objUsuariosDto).createResponse(HttpStatus.CREATED);
	}
	
	

	@PutMapping(value="/usuario")
	public ResponseEntity<WrapperResponse<UsuarioDTO>> update(@RequestBody UsuarioDTO usuario) {
		Usuario objuUsuario = usuarioServi.update(converter.fromDTO(usuario));
		
		UsuarioDTO objUsuarioDto = converter.fromEntity(objuUsuario);
		
		return new WrapperResponse<>(true, "success", objUsuarioDto).createResponse(HttpStatus.OK);
 
	}
	
	
	
	
	@DeleteMapping(value="/usuario/{id}")
	public ResponseEntity<?> delete(@PathVariable ("id") Long id) {
		usuarioServi.delete(id);
		
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);

	}
	@PostMapping(value="/signUp")
	public ResponseEntity<WrapperResponse<UsuarioDTO>> signUp(@RequestBody UsuarioDTO usuario) {
		Usuario nuevoUsuario = usuarioServi.signUp(converter.fromDTO(usuario));
		UsuarioDTO objUsuarioDto = converter.fromEntity(nuevoUsuario);
		return new WrapperResponse<>(true, "success", objUsuarioDto).createResponse(HttpStatus.CREATED);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<WrapperResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO request) {
		LoginResponseDTO response = usuarioServi.login(request);
		return new WrapperResponse<>(true, "success", response).createResponse(HttpStatus.OK);
	}
	

}
