package com.misiontic.proyecto.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.proyecto.entity.Compra;
import com.misiontic.proyecto.exceptions.GeneralServiceException;
import com.misiontic.proyecto.exceptions.NoDataFoundException;
import com.misiontic.proyecto.exceptions.ValidateServiceException;
import com.misiontic.proyecto.repository.CompraRepository;
import com.misiontic.proyecto.validators.CompraValidators;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompraServices {
	
	@Autowired
	private CompraRepository compraRepo;
	
	public List<Compra> findAll() {
		try {
			List<Compra> arregloCompra = compraRepo.findAll();
			return arregloCompra;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Compra findById(Long compraId) {
		try {
			Compra objCompra = compraRepo.findById(compraId)
					.orElseThrow(() -> new NoDataFoundException("No existe la compra."));
			return objCompra;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Compra create(Compra compra) {
		try {
			CompraValidators.validador(compra);
			Compra nuevaCompra = compraRepo.save(compra);
			return nuevaCompra;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Compra update(Compra compra) {
		try {
			CompraValidators.validador(compra);
			Compra objCompra = compraRepo.findById(compra.getIdCompra())
					.orElseThrow(() -> new NoDataFoundException("No existe el pedido."));
			
			objCompra.setIdCliente(compra.getIdCliente());
			objCompra.setFecha(compra.getFecha());
			objCompra.setTotal(compra.getTotal());
			
			compraRepo.save(objCompra);
			
			return objCompra;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

	@Transactional
	public void delete(Long compraId) {
		try {
			Compra objCompra = compraRepo.findById(compraId)
					.orElseThrow(() -> new NoDataFoundException("No existe el pedido."));
			
			compraRepo.delete(objCompra);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

}
