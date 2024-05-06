package com.dio.model;

import java.util.ArrayList;
import java.util.List;

public class SumNumbers {
    
    // Criando e instanciando a lista
    private List<Integer> sumNumbers = new ArrayList<>();
    
    // Métodos
    
    // Método para adicionar o número à lista
    public void addNumber(Integer number){
        sumNumbers.add(number);
    }
    
    // Método para somar todos os números
    public int sumCalc(){
        int sum = 0;
        for (Integer num : sumNumbers) {
            sum += num;
        }
        return sum;
    }
    
    // Método para encontrar o maior número
    public Integer findMaxNumb(){
        int maxNumb = 0;
        for (Integer bigNumber : sumNumbers) {
            if(bigNumber > maxNumb){
                maxNumb = bigNumber;
            }
        }
        return maxNumb;
    }
    
    // Método para encontrar o menor número
    public Integer findMinNumb(){    
        int minNumb = 0;
        int currentNumb = 0;
        for (Integer num : sumNumbers) {
            currentNumb = minNumb;
            if(num != 0 && currentNumb < num){
                currentNumb = minNumb;
            } else {
                currentNumb = num;
            }
            
            minNumb = currentNumb;
        }
        return minNumb;
    }
    
    // Método para listar os números
    public void showNumbers(){
        for (Integer num : sumNumbers) {            
            System.out.println(num); 
        }   
    }
    
    // Método principal
    public static void main(String[] args) {
        
        SumNumbers sumNumbers = new SumNumbers();
        
        // Adicionando números à lista
        sumNumbers.addNumber(5);
        sumNumbers.addNumber(0);
        sumNumbers.addNumber(0);
        sumNumbers.addNumber(-2);
        sumNumbers.addNumber(10);
        
        // Exibindo a lista de números adicionados
        System.out.println("Números adicionados:");
        sumNumbers.showNumbers();
        
        // Calculando e exibindo a soma dos números na lista
        System.out.println("Soma dos números = " + sumNumbers.sumCalc());
        
        // Encontrando e exibindo o maior número na lista
        System.out.println("Maior número = " + sumNumbers.findMaxNumb());
        
        // Encontrando e exibindo o menor número na lista
        System.out.println("Menor número = " + sumNumbers.findMinNumb());
    }
}
