package com.dio.model.entities;

import java.util.HashSet;
import java.util.Set;

public class UniqueWordsSet {

    Set<String> wordsSet = new HashSet<>();

    public UniqueWordsSet() {}
    
    public void addWord(String word){
        wordsSet.add(word);
    }
    
    public void removeWord(String word){
        if (!wordsSet.isEmpty()) {
            if (wordsSet.contains(word)) {
                wordsSet.remove(word);
            } else {
                System.out.println("A palavra não está no conjunto!");
            }
            
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }
    
    public boolean isExist(String word){
        return wordsSet.contains(word);
    }
    
    public void showUniqueWords(){
        if(!wordsSet.isEmpty()) {
          System.out.println(wordsSet);
        } else {
          System.out.println("O conjunto está vazio!");
        }
    }
    
    public static void main(String[] args) {
        
        UniqueWordsSet uniqueWordsSet = new UniqueWordsSet();
        
        // Adicionando linguagens únicas ao conjunto
        uniqueWordsSet.addWord("Java");
        uniqueWordsSet.addWord("Python");
        uniqueWordsSet.addWord("JavaScript");
        uniqueWordsSet.addWord("Python");
        uniqueWordsSet.addWord("C++");
        uniqueWordsSet.addWord("Ruby");

        // Exibindo as linguagens únicas no conjunto
        uniqueWordsSet.showUniqueWords();
        
        // Verificando se uma linguagem está no conjunto antes da remoção
        System.out.println("\nA linguagem 'Java' está no conjunto? " + uniqueWordsSet.isExist("Java"));
        
        System.out.println("\nA linguagem 'Python' está no conjunto? " + uniqueWordsSet.isExist("Python"));

        // Removendo uma linguagem do conjunto
        uniqueWordsSet.removeWord("Python");
        uniqueWordsSet.showUniqueWords();

        // Removendo uma linguagem inexistente
        uniqueWordsSet.removeWord("Swift");

        // Verificando se uma linguagem está no conjunto
        System.out.println("\nA linguagem 'Swift' está no conjunto? " + uniqueWordsSet.isExist("Swift"));
        System.out.println("\nA linguagem 'Python' está no conjunto? " + uniqueWordsSet.isExist("Python"));

        // Exibindo as linguagens únicas atualizadas no conjunto
        uniqueWordsSet.showUniqueWords();
        
    }
}
