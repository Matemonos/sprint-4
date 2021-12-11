package com.misiontic.proyecto.controllers;

import java.util.List;

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

import com.misiontic.proyecto.converters.CompraConverter;
import com.misiontic.proyecto.dtos.CompraDTO;
import com.misiontic.proyecto.entity.Compra;
import com.misiontic.proyecto.services.CompraServices;
import com.misiontic.proyecto.utils.WrapperResponse;


@RestController
public class CompraController {
	
	@Autowired
	private CompraServices compraService;
	private CompraConverter converter = new CompraConverter();
	
	@GetMapping(value="/compra")
	public ResponseEntity<WrapperResponse<List<CompraDTO>>> findAll(){
		List<Compra> arregloCompra = compraService.findAll();
		List<CompraDTO> arregloCompraDto = converter.fromEntity(arregloCompra);
		return new WrapperResponse<>(true, "success", arregloCompraDto).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value="/compra/{compraId}")
	public ResponseEntity<WrapperResponse<CompraDTO>> findById(@PathVariable("compraId") Long compraId) {
		Compra objCompra = compraService.findById(compraId);
		CompraDTO objCompraDto = converter.fromEntity(objCompra);
		return new WrapperResponse<>(true, "success", objCompraDto).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/compra")
	public ResponseEntity<WrapperResponse<CompraDTO>> create(@RequestBody CompraDTO compra) {
		Compra nuevoCompra = compraService.create(converter.fromDTO(compra));
		CompraDTO objCompraDto = converter.fromEntity(nuevoCompra);
		return new WrapperResponse<>(true, "success", objCompraDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/compra")
	public ResponseEntity<WrapperResponse<CompraDTO>> update(@RequestBody CompraDTO compra) {
		Compra objCompra = compraService.update(converter.fromDTO(compra));
		CompraDTO objCompraDto = converter.fromEntity(objCompra);
		return new WrapperResponse<>(true, "success", objCompraDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/compra/{compraId}")
	public ResponseEntity<?> delete(@PathVariable("compraId") Long compraId) {
		compraService.delete(compraId);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	}

}
