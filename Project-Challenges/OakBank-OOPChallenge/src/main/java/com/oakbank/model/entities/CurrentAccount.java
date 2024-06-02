package com.oakbank.model.entities;

import com.oakbank.model.exceptions.InsufficientBalance;
import com.oakbank.model.interfaces.DigitalAccount;

public class CurrentAccount extends Account{

    public CurrentAccount(Client client) {
        super(client);
    }
    
    @Override
    public void withDraw(Double amount) throws InsufficientBalance{
        if(amount < balance || amount < (balance + limit)){
            balance -= amount;
            client.isNegative = true;
        } else {
            throw new InsufficientBalance();
        }
    }
    
    @Override
    public void transfer(Double amount, DigitalAccount targetAccount) throws InsufficientBalance{
        if(amount < balance || amount < (balance + limit)){            
            withDraw(amount);
            targetAccount.deposit(amount);
        } else {
            throw new InsufficientBalance();
        }
    }

    @Override
    public void printAccStatement() {
        System.out.println("=== Extrato da Conta Corrente ===");
        super.showInfo();
    }
    
}
