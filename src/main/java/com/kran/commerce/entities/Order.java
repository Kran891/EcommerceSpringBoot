package com.kran.commerce.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;
    private String name;
    private Date orderDate;
    private Date deliveryDate;
    private int ProductId;
    private  int PayementId;
    
    public Order() {
    }
    public Order(String name, Date orderDate, Date deliveryDate, int productId, int PayementId) {
        this.name = name;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        PayementId = productId;
        ProductId = productId;
    }
    public int getPayementId() {
        return PayementId;
    }
    public void setPayementId(int payementId) {
        PayementId = payementId;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public int getProductId() {
        return ProductId;
    }
    public void setProductId(int productId) {
        ProductId = productId;
    }
    
}
