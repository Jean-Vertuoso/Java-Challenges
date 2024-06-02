package com.oakbank.model.comparators;

import java.util.Comparator;

import com.oakbank.model.entities.Employee;

public class ComparatorByName implements Comparator<Employee>{
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getName().compareToIgnoreCase(emp2.getName());
    }
    
}