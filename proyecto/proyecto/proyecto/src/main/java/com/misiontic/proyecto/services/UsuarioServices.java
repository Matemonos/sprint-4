package com.misiontic.proyecto.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.misiontic.proyecto.converters.UsuarioConverter;
import com.misiontic.proyecto.dtos.LoginRequestDTO;
import com.misiontic.proyecto.dtos.LoginResponseDTO;
import com.misiontic.proyecto.entity.Usuario;
import com.misiontic.proyecto.exceptions.GeneralServiceException;
import com.misiontic.proyecto.exceptions.NoDataFoundException;
import com.misiontic.proyecto.exceptions.ValidateServiceException;
import com.misiontic.proyecto.repository.UsuarioRepository;
import com.misiontic.proyecto.validators.UsuarioValidators;

import ch.qos.logback.core.pattern.Converter;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioServices {

	@Value("${jwt.clave}")
	private String jwtSecret;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	private UsuarioConverter converter = new UsuarioConverter();
	
	
	
	public List<Usuario> findAll(){
		
		
		try {

			List<Usuario> arregloUsuarios = usuarioRepo.findAll();
			return arregloUsuarios;
			
		} catch (ValidateServiceException | NoDataFoundException e) {

			log.info(e.getMessage(), e);
			throw e;

		} catch (Exception a) {

			log.error(a.getMessage(), a);
			throw new GeneralServiceException(a.getMessage(), a);

		}
		

	}


	public Usuario findById(Long id) {
		
		try {
			
			Usuario objUsuario = usuarioRepo.findById(id)
					.orElseThrow(() -> new NoDataFoundException("No existe el Usuario con ese Id."));
			
			return objUsuario;
			
		} catch (ValidateServiceException | NoDataFoundException e) {
		
			log.info(e.getMessage(), e);
			throw e;
			
		}catch (Exception a) {
			
			log.error(a.getMessage(), a);
			throw new GeneralServiceException(a.getMessage(), a);
			
		}
		

	}

	

	@Transactional
	public Usuario Create(Usuario usuario) {
		
		
		try {

			UsuarioValidators.Validador(usuario);
			
			Usuario objUsuario = usuarioRepo.save(usuario);
			return objUsuario;
			
		} catch (ValidateServiceException | NoDataFoundException e) {

			log.info(e.getMessage(), e);
			throw e;

		} catch (Exception a) {

			log.error(a.getMessage(), a);
			throw new GeneralServiceException(a.getMessage(), a);

		}
		
		
		
		
	}
	


	@Transactional
	public Usuario update(Usuario usuario) {
		
		
		try {

			Usuario objUsuario = usuarioRepo.findById(usuario.getId_usuario())
					.orElseThrow(() -> new RuntimeException("No existe el Usuario con ese Id."));
			
			objUsuario.setId_rol(usuario.getId_rol());
			objUsuario.setNombre(usuario.getNombre());
			objUsuario.setApellido(usuario.getApellido());
			objUsuario.setTelefono(usuario.getTelefono());
			objUsuario.setNombreusuario(usuario.getNombreusuario());
			objUsuario.setClave(usuario.getClave());
			
			usuarioRepo.save(objUsuario);
			
			return objUsuario;
			
		} catch (ValidateServiceException | NoDataFoundException e) {

			log.info(e.getMessage(), e);
			throw e;

		} catch (Exception a) {

			log.error(a.getMessage(), a);
			throw new GeneralServiceException(a.getMessage(), a);

		}
		
		
		
	}
	
	
	

	@Transactional
	public void delete(Long id) {
		
		try {

			Usuario objUsuario = usuarioRepo.findById(id)
					.orElseThrow(() -> new RuntimeException("No existe el usuario con ese Id."));
			
			usuarioRepo.delete(objUsuario);
			
		} catch (ValidateServiceException | NoDataFoundException e) {

			log.info(e.getMessage(), e);
			throw e;

		} catch (Exception a) {

			log.error(a.getMessage(), a);
			throw new GeneralServiceException(a.getMessage(), a);

		}
		
		
		
	}
	@Transactional
	public Usuario signUp(Usuario usuario) {
		try {
			Usuario existeUsuario = usuarioRepo.findByNombreusuario(usuario.getNombreusuario())
					.orElse(null);
			
			if (existeUsuario != null) {
				throw new ValidateServiceException("El nombre de usuario ya existe.");
			}
			
			UsuarioValidators.Validador(usuario);
			Usuario nuevoUsuario = usuarioRepo.save(usuario);
			return nuevoUsuario;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	public LoginResponseDTO login(LoginRequestDTO request) {
		
		try {
			//validar que exista el usuario en la db
			Usuario usuario = usuarioRepo.findByNombreusuario(request.getNombreUsuario())
					.orElseThrow(() -> new ValidateServiceException("Nombre de usuario o contraseÃ±a incorrecta."));
			
			//validar que exista la clave en la db
			if (!usuario.getClave().equals(request.getClave())) {
				throw new ValidateServiceException("Nombre de usuario o contraseÃ±a incorrecta.");
			}
			
			//crear token
			String token = createToken(usuario);
			
			return new LoginResponseDTO(converter.fromEntity(usuario), token);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	public String createToken(Usuario usuario) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + (1000 * 60 * 60));
		
		return Jwts.builder()
				.setSubject(usuario.getNombreusuario())
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();	
	}
	
	public boolean validateToken(String token) {
		
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (UnsupportedJwtException e) {
			log.error("JWT in a particular format/configuration that does not match the format expected by the application");
		} catch (MalformedJwtException e) {
			log.error("JWT was not correctly constructed and should be rejected");
		} catch (SignatureException e) {
			log.error("signature or verifying an existing signature of a JWT failed");
		} catch (ExpiredJwtException e) {
			log.error("JWT was accepted after it expired and must be rejected");
		}
		return false;
	}
	
	public String getNombreUsuarioFromToken(String jwt) {
		
		try {
			return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).getBody().getSubject();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ValidateServiceException("Token invalido.");
		}
		
	}
	
}

