package com.kran.commerce.DAO.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kran.commerce.entities.Order;

public interface  IOrdersDAO extends JpaRepository<Order, Integer>{
   @RestResource(path="user")
   @Query("FROM Order where user.id=:id")
   List<Order> findByUserId(@Param("id") UUID id); 
}
