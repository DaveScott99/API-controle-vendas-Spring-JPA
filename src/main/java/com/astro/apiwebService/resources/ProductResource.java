package com.astro.apiwebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astro.apiwebService.entities.Product;
import com.astro.apiwebService.services.ProductService;

@RestController
@RequestMapping(value = "/products") // EndPoint para acessar todos os produtos cadastrados.
public class ProductResource {
	
	@Autowired // Inversão de controle do Spring.
	private ProductService service;
	
	/**
	 * Método para retornar uma lista de produtos cadastrados.
	 * @return Uma lista de produtos.
	 */
	@GetMapping
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
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
}
