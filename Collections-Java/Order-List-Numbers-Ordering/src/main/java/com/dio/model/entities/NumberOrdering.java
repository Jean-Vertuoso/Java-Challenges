package com.dio.model.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOrdering{
    
    // Criando e instanciando lista de números inteiros
    List<Integer> numberList = new ArrayList<>();

    // Construtor
    public NumberOrdering() {}
    
    // Métodos
        
    // Método para adicionar números à lista
    public void addNumber(Integer number){
        numberList.add(number);
    }

    // Método para organizar a lista em ordem ascendente
    public void ascOrder(){
        if (!numberList.isEmpty()) {            
            Collections.sort(numberList);
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }
    
    // Método para organizar a lista em ordem descendente
    public void descOrder(){
        if (!numberList.isEmpty()) {            
            Collections.reverse(numberList);
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }
    
    public void showNumbers(){
        for (Integer num : numberList) {            
            System.out.println(num); 
        }   
    }
    
    public static void main(String[] args) {
        
        NumberOrdering numOrdering = new NumberOrdering();
        
        // Adicionando números à lista
        numOrdering.addNumber(2);
        numOrdering.addNumber(5);
        numOrdering.addNumber(4);
        numOrdering.addNumber(1);
        numOrdering.addNumber(99);

        // Exibindo a lista de números adicionados
        numOrdering.showNumbers();
        System.out.println("---------------------------------------------------");
        // Ordenando e exibindo em ordem ascendente
        numOrdering.ascOrder();
        numOrdering.showNumbers();
        System.out.println("---------------------------------------------------");
        // Ordenando e exibindo em ordem descendente
        numOrdering.descOrder();
        numOrdering.showNumbers();
    }
}
