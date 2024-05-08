package com.dio.model.entities;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student>{
    
    private String name;
    private Long registration;
    private Double average;

    public Student(String name, Long registration, Double average) {
        this.name = name;
        this.registration = registration;
        this.average = average;
    }
    
    @Override
    public int compareTo(Student s) {
        return name.compareToIgnoreCase(s.getName());
    }
    
    public String getName() {
        return name;
    }

    public Long getRegistration() {
        return registration;
    }

    public Double getAverage() {
        return average;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.registration);
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
        final Student other = (Student) obj;
        return Objects.equals(this.registration, other.registration);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Nome: "+ name);
        sb.append(" - Matrícula: "+ registration);
        sb.append(" - Média: "+ average);
        sb.append("\n");
        
        return sb.toString();
    }
    
}

class ComparatorByScore implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getAverage(), o2.getAverage());
    }
}