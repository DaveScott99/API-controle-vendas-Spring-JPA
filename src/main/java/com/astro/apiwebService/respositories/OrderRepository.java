package com.astro.apiwebService.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astro.apiwebService.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
