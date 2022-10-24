package com.astro.apiwebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astro.apiwebService.entities.Category;
import com.astro.apiwebService.services.CategoryService;

@RestController
@RequestMapping(value = "/categories") // EndPoint para acessar todas as categorias.
public class CategoryResource {
	
	@Autowired // Inversão de controle do Spring.
	private CategoryService service;
	
	/**
	 * Método para retornar uma lista de categorias cadastradas.
	 * @return Uma lista de categorias.
	 */
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}

	/**
	 * Método para procurar uma categoria pelo seu id.
	 * @param id que será procurado.
	 * @return A categoria caso seja encontrada.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		
		Category obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
}
