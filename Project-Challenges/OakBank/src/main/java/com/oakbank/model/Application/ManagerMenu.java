package com.oakbank.model.Application;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

import com.oakbank.model.entities.Employee;
import com.oakbank.model.exceptions.InvalidOption;
import com.oakbank.model.comparators.ComparatorByName;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ManagerMenu {
    
    Set<Employee> employeeList;

    public ManagerMenu() {
        employeeList = new HashSet<>();
        employeeList.add(new Employee("Jose da Silva", "Desenvolvedor Java", 3745.00));
        employeeList.add(new Employee("José Pereira", "Analista de Negócios", 4331.00));
        employeeList.add(new Employee("Maria da Rosa", "Arquiteta de Software", 9473.00));
        employeeList.add(new Employee("Ana Souza", "Tech-lead FrontEnd", 11700.00));
    }
    
    public Set<Employee> listByRegister(){
        Set<Employee> listByReg = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getRegister))
                .map(Employee::getRegister)
                .collect(Collectors.toSet());
//        if (!employeeList.isEmpty()) {
//            for (Employee employee : listByReg) {
//                System.out.println(employee);
//            }
//        } else {
//            throw new RuntimeException("A lista está vazia.");
//        }
            return listByReg;
    }
    
    public void listByName(){
        Set<Employee> listByName = new TreeSet<>(new ComparatorByName());
        if (!employeeList.isEmpty()) {
            listByName.addAll(employeeList);
            for (Employee employee : listByName) {
                System.out.println(employee);
            }
        } else {
            System.out.println("A lista está vazia.");
        }
    }
    
    public void findByName(String name){
        
    }
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        ManagerMenu managerMenu = new ManagerMenu();
        
        boolean isUsing = true;
        
        System.out.println("Olá João, seja bem vindo.");
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
                    System.out.println("Digite o nome completo do funcionário que deseja pesquisar: ");
                    String searchName = sc.nextLine();
                    
                    
                    break;
                    
                case 4:
                    System.out.print("Digite o nome completo do funcionário: ");
                    String name = sc.nextLine();
                    
                    System.out.print("Digite o cargo do funcionário: ");
                    String role = sc.nextLine();
                    
                    System.out.print("Digite o salário do funcionário: ");
                    Double salary = sc.nextDouble();
                    
                    managerMenu.employeeList.add(new Employee(name, role, salary));
                    
                    break;
                    
                case 0:
                    System.out.println("\nDeslogando...");
                    isUsing = false;
                    break;
                    
                default:
                    throw new InvalidOption();
                }            
                
            }
            
        } catch (InvalidOption invalidOption) {
            System.out.println("Opção inválida!");
        } finally {        
            sc.close();            
        }
    }
    
}