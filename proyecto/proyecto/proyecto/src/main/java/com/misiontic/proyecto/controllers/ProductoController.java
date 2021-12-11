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

import com.misiontic.proyecto.converters.ProductoConverter;
import com.misiontic.proyecto.dtos.ProductoDTO;
import com.misiontic.proyecto.entity.Producto;
import com.misiontic.proyecto.services.ProductoServices;
import com.misiontic.proyecto.utils.WrapperResponse;



@RestController
public class ProductoController {
	
	@Autowired
	private ProductoServices productoService;
	private ProductoConverter converter = new ProductoConverter();
	@GetMapping(value="/producto")
	public ResponseEntity<WrapperResponse<List<ProductoDTO>>> findAll(){
		List<Producto> arregloProducto = productoService.findAll();
		List<ProductoDTO> arregloProductoDTO = converter.fromEntity(arregloProducto);
		return new WrapperResponse<>(true, "success", arregloProductoDTO).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value="/producto/{idProducto}")
	public ResponseEntity<WrapperResponse<ProductoDTO>> findById(@PathVariable("idProducto") Long IdProducto) {
		Producto objProducto = productoService.findById(IdProducto);
		ProductoDTO objProductoDTO = converter.fromEntity(objProducto);
		return new WrapperResponse<>(true, "success", objProductoDTO).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/producto")
	public ResponseEntity<WrapperResponse<ProductoDTO>> create(@RequestBody ProductoDTO producto) {
		Producto nuevoProducto = productoService.create(converter.fromDTO(producto));
		ProductoDTO objProductoDto = converter.fromEntity(nuevoProducto);
		return new WrapperResponse<>(true, "success", objProductoDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/producto")
	public ResponseEntity<WrapperResponse<ProductoDTO>> update(@RequestBody ProductoDTO producto) {
		Producto objProducto = productoService.update(converter.fromDTO(producto));
		ProductoDTO objProductoDto = converter.fromEntity(objProducto);
		return new WrapperResponse<>(true, "success", objProductoDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/producto/{idProducto}")
	public ResponseEntity<?> delete(@PathVariable("idProducto") Long idProducto) {
		productoService.delete(idProducto);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	}

}
