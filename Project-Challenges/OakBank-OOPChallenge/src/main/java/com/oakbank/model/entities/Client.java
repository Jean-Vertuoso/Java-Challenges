package com.oakbank.model.entities;

public class Client implements Comparable<Client>{
    
    private static int ID = 1;
    
    private String name;
    private Integer age;
    private String cpf;
    private String address;
    protected Boolean isNegative;

    public Client(){}

    public Client(String name, Integer age, String cpf, String address) {
        this.ID = ID++;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.address = address;
        this.isNegative = false;
    }

    @Override
    public int compareTo(Client cli) {
        return name.compareTo(cli.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Boolean isNegative(Account account){
        if(account.getBalance() < 0){
            isNegative = true;
        }
        return isNegative;
    }
    
}
