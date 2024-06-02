package com.dio.model;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    
    private Map<String, Integer> wordCount = new HashMap<>();

    public WordCount() {
    }

    public void addWord(String word, Integer count){
        wordCount.put(word, count);
    }
    
    public void removeWord(String word){
        if (!wordCount.isEmpty()) {
            wordCount.remove(word);
        } else {
            System.out.println("Não há palavras para exibir.");
        }
    }
    
    public int showWordCount(){
        int totalCount = 0;
        for (int count : wordCount.values()) {
            totalCount += count;
        }
        return totalCount;
    }
    
    public String findMoreFreqWord(){
        String moreFreqWord = null;
        Integer numOfTimes = 0;
        if (!wordCount.isEmpty()) {
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()){
                if (entry.getValue() > numOfTimes) {                    
                    numOfTimes = entry.getValue();
                    moreFreqWord = entry.getKey();
                }
            }
        } else {
            System.out.println("Não há palavras para exibir.");
        }
        return moreFreqWord;
    }
    
    public static void main(String[] args) {
        WordCount wordCount = new WordCount();

        // Adiciona linguagens e suas contagens
        wordCount.addWord("Java", 2);
        wordCount.addWord("Python", 8);
        wordCount.addWord("JavaScript", 1);
        wordCount.addWord("C#", 6);

        // Exibe a contagem total de linguagens
        System.out.println("\nExibe a contagem total de linguagens:");
        System.out.println("Existem " + wordCount.showWordCount() + " palavras.");

        // Encontra e exibe a linguagem mais frequente
        System.out.println("\nEncontra e exibe a linguagem mais frequente:");
        String linguagemMaisFrequente = wordCount.findMoreFreqWord();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
    }
}
