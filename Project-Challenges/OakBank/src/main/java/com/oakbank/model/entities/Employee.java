package com.oakbank.model.entities;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Employee {
    
    private Integer register;
    private String name;
    private String role;
    private Double salary;
    
    private Random random;

    public Employee() {}
    
    public Employee(String name, String role, Double salary) {
        random = new Random();
        this.register = random.nextInt(1000);
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

//    @Override
//    public int compareTo(Employee emp) {
//        return register.compareTo(emp.getRegister());
//    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.register);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.register, other.register);
    }

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
        this.register = register;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Número de registro: "+ register);
        sb.append(" - Nome: "+ name);
        sb.append(" - Cargo: "+ role);
        sb.append(" - Salário: R$"+ String.format("%.2f", salary));
        
        return sb.toString();
    }

}