package com.kran.commerce.DAO.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kran.commerce.entities.User;

public interface IUserDAO extends JpaRepository<User, UUID>{

}
