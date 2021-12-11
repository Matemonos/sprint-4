package com.misiontic.proyecto.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.proyecto.entity.Producto;
import com.misiontic.proyecto.exceptions.GeneralServiceException;
import com.misiontic.proyecto.exceptions.NoDataFoundException;
import com.misiontic.proyecto.exceptions.ValidateServiceException;
import com.misiontic.proyecto.repository.ProductoRepository;
import com.misiontic.proyecto.validators.ProductoValidators;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductoServices {

	@Autowired 
	private ProductoRepository productoRepo;
	
	public List<Producto> findAll() {
		try {
			List<Producto> arregloProducto = productoRepo.findAll();
			return arregloProducto;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	
	public Producto findById(Long productoId) {
		try {
			Producto objProducto = productoRepo.findById(productoId)
				.orElseThrow(() -> new NoDataFoundException("No existe el Producto con este Id."));
			return objProducto;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public Producto create(Producto producto) {
		try {
			ProductoValidators.validador(producto);
			Producto nuevoProducto = productoRepo.save(producto);
			return nuevoProducto;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public Producto update(Producto producto) {
		try {
			ProductoValidators.validador(producto);
			Producto objProducto = productoRepo.findById(producto.getIdProducto())
					.orElseThrow(() -> new NoDataFoundException("No existe el producto con ese id."));
			objProducto.setIdProducto(producto.getIdProducto());
			objProducto.setNombre(producto.getNombre());
			objProducto.setCantidad(producto.getCantidad());
			objProducto.setPrecio(producto.getPrecio());
			objProducto.setReferencia(producto.getReferencia());
			objProducto.setExistencias(producto.getExistencias());
			productoRepo.save(objProducto);
			return objProducto;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public void delete(Long idproducto) {
		try {
			Producto objProducto = productoRepo.findById(idproducto)
					.orElseThrow(() -> new NoDataFoundException("No existe el producto con ese id."));
			productoRepo.delete(objProducto);
		} catch (ValidateServiceException  | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		

	}

}
