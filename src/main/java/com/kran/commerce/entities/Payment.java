package com.kran.commerce.entities;

import java.util.Date;

import com.kran.commerce.utils.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  int id;
    private Date payementDate;
    private boolean partialPayment;
    private PaymentType paymentType;
    private float amount;
    private int payementId;
    private int buyerId;
    public Payment(Date payementDate, boolean partialPayment, PaymentType paymentType, float amount, int payementId,final int buyerId) {
        this.payementDate = payementDate;
        this.partialPayment = partialPayment;
        this.paymentType = paymentType;
        this.amount = amount;
        this.payementId = payementId;
        this.buyerId = buyerId;
    }

    public Payment() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getPayementDate() {
        return payementDate;
    }
    public void setPayementDate(Date payementDate) {
        this.payementDate = payementDate;
    }
    public boolean isPartialPayment() {
        return partialPayment;
    }
    public void setPartialPayment(boolean partialPayment) {
        this.partialPayment = partialPayment;
    }
    public PaymentType getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public int getPayementId() {
        return payementId;
    }
    public void setPayementId(int payementId) {
        this.payementId = payementId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }
    
}

