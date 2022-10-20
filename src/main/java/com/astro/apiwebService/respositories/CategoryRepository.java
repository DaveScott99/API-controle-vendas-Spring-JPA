package com.astro.apiwebService.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astro.apiwebService.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
