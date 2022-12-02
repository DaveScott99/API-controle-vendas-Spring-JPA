package com.astro.apiwebService.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.astro.apiwebService.entities.Product;
import com.astro.apiwebService.respositories.ProductRepository;
import com.astro.apiwebService.services.exceptions.DatabaseException;
import com.astro.apiwebService.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		
		return obj.get();
	}
	
	public Product insert(Product product) {
		return repository.save(product);
	}
	
	public Product update(Long id, Product prod) {
		try {
			Product entity = repository.getReferenceById(id);
			updateData(entity, prod);
			return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	private void updateData(Product entity, Product prod) {
		entity.setName(prod.getName());
		entity.setPrice(prod.getPrice());
		entity.setDescription(prod.getDescription());
		entity.setImgUrl(prod.getImgUrl());
	}
	
}
