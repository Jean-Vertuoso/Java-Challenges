package com.oakbank.model.Application;

import com.oakbank.model.exceptions.IncorrectClientAccessData;
import com.oakbank.model.exceptions.IncorrectEmployeeAccessData;
import java.util.Scanner;

import com.oakbank.model.exceptions.InvalidOption;
import com.oakbank.model.services.AuthService;

public class Menu {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        AuthService authService = new AuthService();
        
        Boolean isAuth;
        
        System.out.println("\nBem vindo ao Oak Bank!");
        System.out.println("\nEscolha uma das opções de acesso:");
        System.out.println(
            "1 - Gestão\n"
            + "2 - Operacional\n"
            + "3 - Cliente\n"
            + "0 - Sair");
        
        try {
            System.out.print("\nDigite sua opção: ");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:            
                    System.out.println("\nDigite seu usuário e senha: ");
                    System.out.printf("Usuário: ");
                    String user = sc.next();

                    System.out.printf("Senha: ");
                    String password = sc.next();
                    
                    isAuth = authService.validateManagerUser(user, password);

                    if (isAuth) {
                        ManagerMenu.main(args);
                    } else {
                        throw new IncorrectEmployeeAccessData();
                    }
                    
                break;
                    
                case 2: 
                    System.out.println("\nDigite seu usuário e senha: ");
                    System.out.printf("Usuário:");
                    user = sc.next();
                    
                    System.out.printf("Senha:");
                    password = sc.next();
                    
                    if (authService.validateEmployeeUser(user, password)) {
                        System.out.println("usuario funcionario validado");
                    } else {
                        throw new IncorrectEmployeeAccessData();
                    }
                    
                break;
                
                case 3:  
                    System.out.println("\nDigite seu usuário e senha: ");
                    System.out.printf("Usuário:");
                    user = sc.next();
                    
                    System.out.printf("Senha:");
                    password = sc.next();
                    
                    if (authService.validateEmployeeUser(user, password)) {
                        System.out.println("usuario cliente validado");
                    } else {
                        throw new IncorrectClientAccessData();
                    }
                break;
                
                case 0:
                    System.out.println("\nPrograma encerrado");
                break;
                default:
                    throw new InvalidOption();
            }
            
        } catch (InvalidOption invalidOption) {
            System.out.println("Opção inválida!");
        } catch (IncorrectEmployeeAccessData invalidEmpData) {
            System.out.println("\nUsuário ou senha inválidos ou não correspondente ao setor.");
        } catch (IncorrectClientAccessData invalidClientData) {
            System.out.println("\nUsuário ou senha inválidos.");
        } finally {
            sc.close();
        }
    }
    
}
