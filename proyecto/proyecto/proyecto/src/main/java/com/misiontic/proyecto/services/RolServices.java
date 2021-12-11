package com.misiontic.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.proyecto.entity.Rol;
import com.misiontic.proyecto.exceptions.GeneralServiceException;
import com.misiontic.proyecto.exceptions.NoDataFoundException;
import com.misiontic.proyecto.exceptions.ValidateServiceException;
import com.misiontic.proyecto.repository.RolRepository;
import com.misiontic.proyecto.validators.RolValidators;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RolServices {
	
	@Autowired
	private RolRepository rolRepo;

	public List<Rol> findAll() {
		try {
			List<Rol> arreglorol = rolRepo.findAll();
			return arreglorol;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	public Rol findById(Long rolId) {
		try {
			Rol objrol = rolRepo.findById(rolId)
					.orElseThrow(() -> new NoDataFoundException("No existe este rol con ese id."));
			return objrol;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Rol create(Rol rol) {
		try {
			RolValidators.validador(rol);
			Rol nuevoRol = rolRepo.save(rol);
			return nuevoRol;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public Rol update(Rol rol) {
		try {
			RolValidators.validador(rol);
			Rol objrol = rolRepo.findById(rol.getIdrol())
					.orElseThrow(() -> new NoDataFoundException("No existe el perfil con ese id."));
			objrol.setNombre(rol.getNombre());
			rolRepo.save(objrol);
			return objrol;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

	@Transactional
	public void delete(Long rolId) {
		try {
			Rol objrol = rolRepo.findById(rolId)
					.orElseThrow(() -> new NoDataFoundException("No existe el perfil con ese id."));
			rolRepo.delete(objrol);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

}
