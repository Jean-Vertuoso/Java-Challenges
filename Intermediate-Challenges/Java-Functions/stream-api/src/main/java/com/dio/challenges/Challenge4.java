package com.dio.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Challenge4 {
    
    public static void main(String[] args) {

    //TODO Remova todos os valores ímpares:
    //Utilize a Stream API para remover os valores ímpares da lista e imprima a lista resultante no console.
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
    
    Predicate<Integer> evenNumbers = number -> number % 2 == 0; 
    
    numbers.stream().filter(evenNumbers).forEach(System.out::println);
    
    }
}
