package com.kran.commerce.DAO.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kran.commerce.entities.Payment;

public interface IPaymentDAO extends JpaRepository<Payment, Integer>{

}
