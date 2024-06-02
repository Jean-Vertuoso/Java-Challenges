package com.oakbank.model.Application;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

import com.oakbank.model.entities.Employee;
import com.oakbank.model.exceptions.InvalidOption;
import com.oakbank.model.comparators.ComparatorByName;
import com.oakbank.model.exceptions.EmptyList;

public class ManagerMenu {
    
    //Lista de Funcionários com SET
    Set<Employee> employeeList;

    //Construtor vazio para instaciar
    public ManagerMenu() {}
    
    //Construtor
    public ManagerMenu(Employee employee) {
        employeeList = new HashSet<>();
        employeeList.add(new Employee("José da Silva", "Desenvolvedor Java", 3745.00));
        employeeList.add(new Employee("José Pereira", "Analista de Negócios", 4331.00));
        employeeList.add(new Employee("Maria da Rosa", "Arquiteta de Software", 9473.00));
        employeeList.add(new Employee("Ana Souza", "Tech-lead FrontEnd", 11700.00));
    }
    
    //Opção 1: Listar os funcionários organizados pelo Número do Registro utilizando interface Comparable
    public void listByRegister() throws EmptyList{
        Set<Employee> listByReg = new TreeSet<>(employeeList);
        if (!employeeList.isEmpty()) {
            for (Employee employee : listByReg) {
                System.out.println(employee);
            }
        } else {
            throw new EmptyList();
        }
    }
    
    //Opção 2: Listar os funcionários organizados pelo nome(ordem alfabética) utilizando Comparator
    public void listByName() throws EmptyList{
        Set<Employee> listByName = new TreeSet<>(new ComparatorByName());
        if (!employeeList.isEmpty()) {
            listByName.addAll(employeeList);
            for (Employee employee : listByName) {
                System.out.println(employee);
            }
        } else {
            throw new EmptyList();
        }
    }
    
    //Opção 3: Encontrar um funcionário por parte do nome, ou nome completo
    public void findByName(String name) throws EmptyList{
        Set<Employee> findByName = new TreeSet<>(new ComparatorByName());
        if (!employeeList.isEmpty()) {
            for (Employee employee : employeeList) {
                if(employee.getName().startsWith(name) || employee.getName().equalsIgnoreCase(name)){
                    findByName.add(employee);
                }
            }
            for (Employee employee : findByName) {
                System.out.println(employee);
            }
            
            if(findByName.isEmpty()) {
                System.out.println("\nO funcionario solicitado não foi encontrado.");
            }
        } else {
            throw new EmptyList();
        }
    }
    
    //Opção 4: Adiciona um novo funcionário à lista de funcionários
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    
    //Método principal
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        ManagerMenu managerMenu = new ManagerMenu();
        
        boolean isUsing = true;
        
        System.out.println("Olá USUARIO_GESTAO, seja bem vindo.");
        System.out.println("\nO que deseja realizar: \n"
            + "1 - Listar funcionários organizados pelo número de registro\n"
            + "2 - Listar funcionarios organizados pelo nome\n"
            + "3 - Pesquisar funcionário pelo nome\n"
            + "4 - Registrar funcionário\n"
            + "0 - Deslogar");
        
        try {
            while (isUsing) {            
                System.out.print("\nDigite sua opção: ");
                int opt = sc.nextInt();
                sc.nextLine();
                System.out.println("");
                
                switch (opt) {
                case 1:
                    managerMenu.listByRegister();
                    break;
                
                case 2:
                    managerMenu.listByName();
                    break;
                    
                case 3:
                    System.out.print("Digite o nome do funcionário: ");
                    String searchName = sc.nextLine();
                    
                    managerMenu.findByName(searchName);                    
                    break;
                    
                case 4:
                    System.out.print("Digite o nome completo do funcionário: ");
                    String name = sc.nextLine();
                    
                    System.out.print("Digite o cargo do funcionário: ");
                    String role = sc.nextLine();
                    
                    System.out.print("Digite o salário do funcionário: ");
                    Double salary = sc.nextDouble();
                    
                    managerMenu.addEmployee(new Employee(name, role, salary));
                    
                    break;
                    
                case 0:
                    System.out.println("Deslogando...");
                    isUsing = false;
                    Menu.main(args);
                    break;
                    
                default:
                    throw new InvalidOption();
                }            
                
            }
            
        } catch (InvalidOption invalidOption) {
            System.out.println("Opção inválida!");
        } catch (EmptyList emptylist) {
            System.out.println("A lista está vazia.");
        } finally {        
            sc.close();            
        }
    }
    
}