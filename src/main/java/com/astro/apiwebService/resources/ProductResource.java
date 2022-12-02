package com.astro.apiwebService.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.astro.apiwebService.entities.Product;
import com.astro.apiwebService.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/products") // EndPoint para acessar todos os produtos cadastrados.
@Api(tags = "Product Resource")
public class ProductResource {
	
	@Autowired // Inversão de controle do Spring.
	private ProductService service;
	
	/**
	 * Método para retornar uma lista de produtos cadastrados.
	 * @return Uma lista de produtos.
	 */
	@GetMapping
	@ApiOperation("Find all Products")
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/**
	 * Método para procurar um produto pelo seu id.
	 * @param id que será procurado.
	 * @return A produto caso seja encontrada.
	 */
	@GetMapping(value = "/{id}")
	@ApiOperation("Find Product by ID")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ApiOperation("Add Product")
	public ResponseEntity<Product> insert(@RequestBody Product obj) {
		obj = service.insert(obj);
		URI uri	= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation("Delete Product")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation("Edit Product")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product obj) {
		
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
