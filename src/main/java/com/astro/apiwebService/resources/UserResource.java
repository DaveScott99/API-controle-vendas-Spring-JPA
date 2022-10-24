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

import com.astro.apiwebService.entities.User;
import com.astro.apiwebService.services.UserService;

@RestController
@RequestMapping(value = "/users") // EndPoint para acessar todos os usuários.
public class UserResource {
	
	@Autowired // Inversão de controle do Spring.
	private UserService service;
	
	/**
	 * Método para retornar uma lista com todos os usuários cadastrados.
	 * @return Os usuários cadastrados.
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	/**
	 * Método para buscar um usuário pelo seu id.
	 * @param id que será procurado.
	 * @return O usuário caso seja encontrado.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}

	/**
	 * Método para adicionar usuários ao banco de dados.
	 * @param obj O objeto usuário com os dados que seram cadastrados.
	 * @return O objeto completo postado no banco de dados.
	 */
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		
		obj = service.insert(obj);
		
		// Linha de código para converter o objeto em URI.
		URI uri	= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	/**
	 * Método para deletar um usuário a partir do seu id.
	 * @param id do usuário que srá deletado.
	 * @return Não será retornado nada.
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Método para atualizar o cadastro de um usuário.
	 * @param id do cadastro que será atualizado.
	 * @param obj formado com as informações que serão atualizadas.
	 * @return Retorna o objeto atualizado.
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
