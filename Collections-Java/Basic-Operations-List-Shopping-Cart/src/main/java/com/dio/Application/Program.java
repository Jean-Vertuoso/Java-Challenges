package com.dio.Application;

import java.util.Scanner;

import com.dio.model.entities.Item;
import com.dio.model.entities.ShoppingCart;
import java.util.Locale;

public class Program {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        
        ShoppingCart shoppingCart = new ShoppingCart();
        boolean toExit = false;
        
        int cont = 1;
        
        System.out.println("Digite uma das opcoes:");
        System.out.println("1 - Adicionar ao carrinho\n2 - Remover do carrinho\n3 - Calcular valor total\n4 - Consultar itens do carrinho\n0 - Sair");
        try {
        while(toExit != true){
            System.out.print("\nOpcao: ");
            Integer opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    System.out.printf("Digite o nome do "+cont+"º do item: ");
                    String name = sc.nextLine();
                    
                    System.out.print("Digite o preco do "+cont+"º item: ");
                    Double price = sc.nextDouble();
                    
                    System.out.print("Digite a quantidade do "+cont+"º item: ");
                    Integer quantity = sc.nextInt();
                    
                    Item item = new Item(name, price, quantity);
                    
                    shoppingCart.addItem(item);                    
                    cont++;
                    break;
                case 2:
                    System.out.print("Digite o nome do item que deseja remover: ");
                    String nameToRemove = sc.nextLine();
                    shoppingCart.removeItem(nameToRemove);
                    break;
                case 3:
                    System.out.println("Valor total atual: R$"+ String.format("%.2f", shoppingCart.calcTotalValue()));
                    break;
                case 4:
                    shoppingCart.showItems();
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    toExit = true;
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente");
            }
        }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        } finally {
            sc.close();
        }
    }
    
    
}
