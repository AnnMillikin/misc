package com.skillsoft.junit;

public class AccountDetails {

    private String name;
    private Double accountNumber;
    private Integer customerID;
    private Double balance;
    private String accountType;

    public AccountDetails(String name, Double accountNumber, Integer customerID, Double balance, String accountType) {
        System.out.println("in AccountDetails constructor ");
        this.name = name;
        this.accountNumber = accountNumber;
        this.customerID = customerID;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void deposit(double deposit){
        balance+=+deposit;
    }

    public boolean withdraw(double withdrawal){
        if(balance-withdrawal>=0) {
            balance-= withdrawal;
            return true;
        } else {
            System.out.println(withdrawal + " is greater than your balance.  Insufficient funds.");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
