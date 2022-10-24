package com.astro.apiwebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astro.apiwebService.entities.Order;
import com.astro.apiwebService.services.OrderService;

@RestController
@RequestMapping(value = "/orders") // EndPoint para acessar todas as ordens.
public class OrderResource {
	
	@Autowired // Inversão de controle do Spring.
	private OrderService service;
	
	/**
	 * Método para retornar uma lista de ordens cadastradas.
	 * @return Uma lista de ordens.
	 */
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}

	/**
	 * Método para procurar uma ordem pelo seu id.
	 * @param id que será procurado.
	 * @return A ordem caso seja encontrada.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		Order obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
}
