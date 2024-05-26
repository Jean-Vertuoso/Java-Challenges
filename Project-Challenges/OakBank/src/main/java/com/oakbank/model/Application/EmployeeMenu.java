package com.oakbank.model.Application;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.oakbank.model.entities.Client;
import com.oakbank.model.exceptions.EmptyList;

public class EmployeeMenu {

    //Lista de Clientes com SET
    Set<Client> clientList;

    //Construtor vazio para instaciar
    public EmployeeMenu() {}

    //Construtor
    public EmployeeMenu(Client client) {
        clientList = new HashSet<>();
        clientList.add(new Client("José da Silva Pedro", 19, "088.978.978-85", "Rua das Flores, 518"));
        clientList.add(new Client("Paula da Rosa", 26, "875.986.978-15", "Av. Cintino Pedro"));
        clientList.add(new Client("Amanda Vefago", 35, "152.654.356-89", "Rod. SC-449"));
        clientList.add(new Client("Ronaldo Brito", 65, "352.649.678-12", "Rua Hugo Nantes"));
    }
    
    //Opção 1: Criar lista de clientes organizada por nome utilizando interface Comparable
    public void listByName() throws EmptyList{
        Set<Client> listByName = new TreeSet<>(clientList);
        if (!clientList.isEmpty()) {
            for (Client employee : listByName) {
                System.out.println(employee);
            }
        } else {
            throw new EmptyList();
        }
    }
    
    //Opção 2: Listar todos os clientes negativados
    
    
    // Método principal MAIN
    public static void main(String[] args) {
        
    }
    
}
