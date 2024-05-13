package com.oakbank.model.entities;

import com.oakbank.model.interfaces.DigitalAccount;

public abstract class Account implements DigitalAccount{    

    @Override
    public void withdraw() {
    }

    @Override
    public void deposit() {
    }

    @Override
    public void checkBalance() {
    }

    @Override
    public void checkLimit() {
    }
    
}
