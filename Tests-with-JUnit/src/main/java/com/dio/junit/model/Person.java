package com.dio.junit.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Person {
    
    private String nome;
    private LocalDateTime dateOfBirth;

    public Person(String nome, LocalDateTime dateOfBirth) {
        this.nome = nome;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(){
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDateTime.now());
    }
    
    public boolean isOfLegalAge(){
        return getAge() >= 18;
    }
}
