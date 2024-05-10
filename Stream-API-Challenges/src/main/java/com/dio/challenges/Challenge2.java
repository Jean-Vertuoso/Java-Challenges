package com.dio.challenges;

import java.util.Arrays;
import java.util.List;

public class Challenge2 {
    
    public static void main(String[] args) {
        
    //TODO Desafio 2 - Imprima a soma dos números pares da lista:
    //Utilizando a Stream API, realize a soma dos números pares da lista e exiba o resultado no console.
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
    
    int result = numbers.stream()
        .filter(number -> number % 2 ==0)
        .reduce(0, Integer::sum);
    
        System.out.println("A soma de todos os números pares é: " +result);
    }
    
}
