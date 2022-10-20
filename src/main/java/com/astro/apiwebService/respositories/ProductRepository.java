package com.astro.apiwebService.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astro.apiwebService.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
