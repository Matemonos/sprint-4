package com.misiontic.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.proyecto.converters.Detalle_Compra_Converter;
import com.misiontic.proyecto.dtos.Detalle_Compra_DTO;
import com.misiontic.proyecto.entity.Detalle_Compra;
import com.misiontic.proyecto.services.Detalle_Compra_Services;
import com.misiontic.proyecto.utils.WrapperResponse;



@RestController
public class Detalle_Compra_Controller {
	
	@Autowired
	private Detalle_Compra_Services detalleCompraService;
	private Detalle_Compra_Converter converter = new Detalle_Compra_Converter();
	
	
	@GetMapping(value="/detalle_compra/{detallecompraId}")
	public ResponseEntity<WrapperResponse<Detalle_Compra_DTO>> findById(@PathVariable("detallecompraId") Long detallecompraId) {
		Detalle_Compra objDetalleCompra = detalleCompraService.findById(detallecompraId);
		Detalle_Compra_DTO objDetalle_CompraDto = converter.fromEntity(objDetalleCompra);	
		return new WrapperResponse<>(true, "success", objDetalle_CompraDto).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/detalle_compra")
	public ResponseEntity<WrapperResponse<Detalle_Compra_DTO>> create(@RequestBody Detalle_Compra_DTO detallecompra) {
		Detalle_Compra nuevoDetalleCompra = detalleCompraService.create(converter.fromDTO(detallecompra));
		Detalle_Compra_DTO objDetalle_CompraDto = converter.fromEntity(nuevoDetalleCompra);
		return new WrapperResponse<>(true, "success", objDetalle_CompraDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/detalle_compra")
	public ResponseEntity<WrapperResponse<Detalle_Compra_DTO>> update(@RequestBody Detalle_Compra_DTO detallecompra) {
		Detalle_Compra objDetalleCompra = detalleCompraService.update(converter.fromDTO(detallecompra));
		Detalle_Compra_DTO objDetalle_CompraDto = converter.fromEntity(objDetalleCompra);
		return new WrapperResponse<>(true, "success", objDetalle_CompraDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/detalle_compra/{detallecompraId}")
	public ResponseEntity<?> delete(@PathVariable("detallecompraId") Long detallecompraId) {
		detalleCompraService.delete(detallecompraId);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	
		}

}
