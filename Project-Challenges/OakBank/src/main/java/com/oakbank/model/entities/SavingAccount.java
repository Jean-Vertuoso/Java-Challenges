package com.oakbank.model.entities;

import com.oakbank.model.exceptions.InsufficientBalance;
import com.oakbank.model.interfaces.DigitalAccount;

public class SavingAccount extends Account{

    public SavingAccount(Client client) {
        super(client);
    }
    
    @Override
    public void withDraw(Double amount) throws InsufficientBalance{
        if(amount < balance){
            balance -= amount;
        } else {
            throw new InsufficientBalance();
        }
    }
    
    @Override
    public void transfer(Double amount, DigitalAccount targetAccount) throws InsufficientBalance{
        if(amount < balance){            
            withDraw(amount);
            targetAccount.deposit(amount);
        } else {
            throw new InsufficientBalance();
        }
    }

    @Override
    public void printAccStatement(){
        System.out.println("=== Extrato da Conta Poupança ===");
        super.showInfo();
    }
}
