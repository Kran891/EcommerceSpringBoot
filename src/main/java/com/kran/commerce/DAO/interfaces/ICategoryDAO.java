package com.kran.commerce.DAO.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kran.commerce.entities.Category;
//But default it will create serive and mapping and helps in perform CRUD opertion
//Creates Controllers,Services,DAO for us
//For these need to Add Depedency in Pom.xml
//Dependency Name 
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-data-rest</artifactId> 
@RepositoryRestResource(path = "categories")
public interface ICategoryDAO extends JpaRepository<Category, Integer>{
    
}
