package com.dio.challenges;

import java.util.Arrays;
import java.util.List;

public class Challenge3 {
    
    public static void main(String[] args) {
        
    //TODO Desafio 3 - Verifique se todos os números da lista são positivos:
    //Com a ajuda da Stream API, verifique se todos os números da lista são positivos e exiba o resultado no console.
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
    
    boolean arePositive = numbers.stream().allMatch(number -> number > 0);
    
        if (arePositive) {
            System.out.println("Todos os números são positivos.");
        } else {
            System.out.println("Nem todos os números são positivos.");
        }
    }
    
}
