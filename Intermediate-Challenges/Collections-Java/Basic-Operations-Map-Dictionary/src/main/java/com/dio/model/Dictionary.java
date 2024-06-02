package com.dio.model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    
    private Map<String,String> dictionary = new HashMap<>();

    public Dictionary() {
    }
    
    private void addWord(String word, String definition){
        dictionary.put(word, definition);
    }
    
    private void removeWord(String word){
        if (!dictionary.isEmpty()) {            
            dictionary.remove(word);
        } else {
            System.out.println("O dicionário está vazio.");
        }
    }
    
    public void showWords(){
        if (!dictionary.isEmpty()) {            
            System.out.println(dictionary);
        } else {
            System.out.println("O dicionário está vazio.");
        }
    }
    
    public String findByWord(String word){
        String byWord = null;
        if (!dictionary.isEmpty()) {
            byWord = dictionary.get(word);
            if (byWord == null) {
                System.out.println("Palavra não encontrada no dicionário.");
            }
        } else {
            System.out.println("A agenda de contatos está vazia.");
        }
        return byWord;
    }
    
    public static void main(String[] args) {
        
        Dictionary dictionary = new Dictionary();

        // Adicionar palavras (linguagens de programação)
        dictionary.addWord("java", "Linguagem de programação orientada a objetos.");
        dictionary.addWord("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dictionary.addWord("kotlin", "Linguagem moderna de programação para a JVM.");

        // Exibir todas as palavras
        System.out.println("\nExibindo todas as palavras:");
        dictionary.showWords();

        // Pesquisar palavras
        System.out.println("\nPesquisando por palavra e exibindo definição de 'Java':");
        String definicaoJava = dictionary.findByWord("java");
        System.out.println("Definição da linguagem 'java': " + definicaoJava);

        System.out.println("\nPesquisando por palavra e exibindo definição de 'CSharp':");
        String definicaoCSharp = dictionary.findByWord("csharp");
        System.out.println(definicaoCSharp);

        // Remover uma palavra
        System.out.println("\nRemovendo a palavra 'Typescript' e mostrando todas as palavras:");
        dictionary.removeWord("typescript");
        dictionary.showWords();
    }
}
