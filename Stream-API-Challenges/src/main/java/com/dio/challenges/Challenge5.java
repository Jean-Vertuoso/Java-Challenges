package com.dio.challenges;

import java.util.Arrays;
import java.util.List;

public class Challenge5 {
    
    public static void main(String[] args) {
        
    //TODO Remova todos os valores ímpares:
    //Utilize a Stream API para remover os valores ímpares da lista e imprima a lista resultante no console.
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
    
    //Consumer<Integer> media
    
    Long valor = numbers.stream().filter(number -> number > 5).count();
    
//    Long qtdNumberCinco = numbers.stream().count();
    
        System.out.println(valor);
        
    }
    
}
