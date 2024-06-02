package com.dio.model.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    // Atributos
    private List<Item> itemList = new ArrayList<>();

    // Construtor
    public ShoppingCart() {}
    
    // Getters
    public List<Item> getItemList() {
        return itemList;
    }
    
    // Métodos
    
    // Método para adicionar item à lista
    public void addItem(Item item){
        itemList.add(item);
    }
    
    //Método para remover item da lista
    public void removeItem(String items){
        List<Item> itemsToRemove = new ArrayList<>();
        if (!itemList.isEmpty()) {
            //itemList.remove(itemToRemove);
            
            for (Item item : itemList) {
                if(item.getName().equalsIgnoreCase(items)){
                    itemsToRemove.add(item);
                }
            }
        itemList.removeAll(itemsToRemove);
        } else {
            System.out.println("A lista está vazia!");
        }
    }
    
    // Método para calcular valor total
    public double calcTotalValue(){
        double sum = 0;
        
        for (Item item : itemList) {
            sum += item.getSubPrice();
        }
        
        return sum;
    }
    
    // Método para mostrar informações dos items da lista
    public void showItems(){        
        if (!itemList.isEmpty()) {            
            for (Item item : itemList) {            
                StringBuilder sb = new StringBuilder();
                
                sb.append("Nome: "+ item.getName());
                sb.append(" - Preco: "+ String.format("%.2f", item.getPrice()));
                sb.append(" - Quantidade: "+ item.getQuantity());
                
                System.out.println(sb.toString());
            }
        } else {
            System.out.println("A lista está vazia!");
        }
    }
}
