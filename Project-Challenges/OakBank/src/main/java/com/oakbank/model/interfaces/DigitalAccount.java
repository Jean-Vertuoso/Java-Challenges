package com.oakbank.model.interfaces;

import com.oakbank.model.exceptions.InsufficientBalance;

public interface DigitalAccount {
    
    void withDraw(Double amount) throws InsufficientBalance;
    void deposit(Double amount);
    void transfer(Double amount, DigitalAccount targetAccount) throws InsufficientBalance;
    void printAccStatement();
    
}
