package com.usk.dto;

public class PaymentRequest {
    private String accountNumber;
    private double amount;

    public PaymentRequest() {
        super();
    }

    public PaymentRequest(String accountNumber, double amount) {
        super();
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "accountNumber='" + accountNumber + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
