package com.kran.commerce.DAO.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kran.commerce.entities.UserRoles;
@RepositoryRestResource(path="roles")
public interface IRoleDAO extends JpaRepository<UserRoles, Integer>{
   @RestResource(path="user")
   @Query("FROM UserRoles where user.id=:id")
   List<UserRoles> rolesByUserId(@Param("id") UUID id);
}
