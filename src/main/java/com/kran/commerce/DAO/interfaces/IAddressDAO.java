package com.kran.commerce.DAO.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kran.commerce.entities.Address;
@RepositoryRestResource(path="addresses")
public interface  IAddressDAO extends   JpaRepository<Address, Integer>{
    //To Find the user all address
    // "/addresses/search/user?Id={Id}"
    @Query("FROM Address where user.id=:Id")
    @RestResource(path="user")
    List<Address> findByUserId(@Param("uId") UUID uId);
}
