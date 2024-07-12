package com.oakbank.model.entities;

import com.oakbank.model.exceptions.InsufficientBalance;
import com.oakbank.model.interfaces.DigitalAccount;

public abstract class Account implements DigitalAccount{
    
    private static final int DEFAULT_AGENCY = 5246;
    private static int SERIAL = 1;
    
    protected Integer agencyNumber;
    protected Integer accountNumber;
    protected Double balance;
    protected Double limit;
    protected Client client;

    public Account(Client client) {
        this.agencyNumber = Account.DEFAULT_AGENCY;
        this.accountNumber = SERIAL++;
        this.client = client;
    }

    @Override
    public void deposit(Double amount) {
        balance += amount;
    }

    public Integer getAgencyNumber() {
        return agencyNumber;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getLimit() {
        return limit;
    }
    
    protected String showInfo() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("Titular: %s", this.client.getName()));
        sb.append(String.format("\nAgência: %d", this.agencyNumber));
        sb.append(String.format("\nNúmero da conta: %d", this.accountNumber));
        sb.append(String.format("\nSaldo: %.2f", this.balance));
        
        return sb.toString();
    }
    
}
