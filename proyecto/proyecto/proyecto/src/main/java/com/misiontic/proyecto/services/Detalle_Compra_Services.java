package com.misiontic.proyecto.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.proyecto.entity.Detalle_Compra;
import com.misiontic.proyecto.exceptions.GeneralServiceException;
import com.misiontic.proyecto.exceptions.NoDataFoundException;
import com.misiontic.proyecto.exceptions.ValidateServiceException;
import com.misiontic.proyecto.repository.Detalle_Compra_Repository;
import com.misiontic.proyecto.validators.Detalle_Compra_Validators;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Detalle_Compra_Services {


	@Autowired
	private Detalle_Compra_Repository detalleCompraRepo;
	
	
	public Detalle_Compra findById(Long detallecompraId) {
		try {

			Detalle_Compra objDetalleCompra = detalleCompraRepo.findById(detallecompraId)
					.orElseThrow(() -> new RuntimeException("No existe el detalle con ese Id."));
			return objDetalleCompra;
		} catch (ValidateServiceException | NoDataFoundException e) {

			log.info(e.getMessage(), e);
			throw e;

		} catch (Exception a) {

			log.error(a.getMessage(), a);
			throw new GeneralServiceException(a.getMessage(), a);

		}
	}
	
	@Transactional
	public Detalle_Compra create(Detalle_Compra detalle_compra) {
		try {

			Detalle_Compra_Validators.detalle_compraValidador(detalle_compra);
			Detalle_Compra nuevoDetalleCompra = detalleCompraRepo.save(detalle_compra);
			return nuevoDetalleCompra;
		} catch (ValidateServiceException | NoDataFoundException e) {

			log.info(e.getMessage(), e);
			throw e;

		} catch (Exception a) {

			log.error(a.getMessage(), a);
			throw new GeneralServiceException(a.getMessage(), a);

		}
	}
	
	@Transactional
	public Detalle_Compra update(Detalle_Compra detalle_compra) {
		try {

			Detalle_Compra_Validators.detalle_compraValidador(detalle_compra);
			
			Detalle_Compra objDetalleCompra = detalleCompraRepo.findById(detalle_compra.getId_detalle())
					.orElseThrow(() -> new RuntimeException("No existe el perfil con ese Id."));
			
			objDetalleCompra.setId_producto(detalle_compra.getId_producto());
			objDetalleCompra.setId_compra(detalle_compra.getId_compra());
			objDetalleCompra.setCantidad(detalle_compra.getCantidad());
			objDetalleCompra.setTotal(detalle_compra.getTotal());
			detalleCompraRepo.save(objDetalleCompra);
			return objDetalleCompra;
		} catch (ValidateServiceException | NoDataFoundException e) {

			log.info(e.getMessage(), e);
			throw e;

		} catch (Exception a) {

			log.error(a.getMessage(), a);
			throw new GeneralServiceException(a.getMessage(), a);

		}
	}
	
	@Transactional
	public void delete(Long detallecompraId) {
		try {

			Detalle_Compra objDetalleCompra = detalleCompraRepo.findById(detallecompraId)
					.orElseThrow(() -> new RuntimeException("No existe el perfil con ese Id."));
			
			detalleCompraRepo.delete(objDetalleCompra);
		} catch (ValidateServiceException | NoDataFoundException e) {

			log.info(e.getMessage(), e);
			throw e;

		} catch (Exception a) {

			log.error(a.getMessage(), a);
			throw new GeneralServiceException(a.getMessage(), a);

		}
		
	}

}
