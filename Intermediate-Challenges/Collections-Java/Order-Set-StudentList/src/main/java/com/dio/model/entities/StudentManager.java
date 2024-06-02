package com.dio.model.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StudentManager {

    private Set<Student> studentList = new HashSet<>();

    public StudentManager() {}
    
    public void addStudent(String name, Long registration, Double average){
        studentList.add(new Student(name, registration, average));
    }
    
    public void removeStudent(Long registration){
        Student studentToRemove = null;
        if (!studentList.isEmpty()) {
            for (Student student : studentList) {
                if(student.getRegistration().equals(registration)){
                    studentToRemove = student;
                    break;
                }
            }
            studentList.remove(studentToRemove);
        } else {
            System.out.println("A lista de alunos está vazia!");
        }
        
        if(studentToRemove == null){
            System.out.println("Matrícula não encontrada!");
        }
    }
    
    public void showStudentByName(){
        Set<Student> studentsByName = new TreeSet<>(studentList);
        if (!studentList.isEmpty()) {        
            System.out.println(studentsByName);            
        } else {
            throw new RuntimeException("A lista de alunos está vazia!");
        }
    }
    
    public void showStudentByScore(){        
        Set<Student> studentsByScore = new TreeSet<>(new ComparatorByScore());
        if (!studentList.isEmpty()){
            studentsByScore.addAll(studentList);
            System.out.println(studentsByScore);           
        } else {
            throw new RuntimeException("A lista de alunos está vazia!");
        }
    }
    
    public static void main(String[] args) {
        
    StudentManager studentManager = new StudentManager();

    // Adicionando alunos ao gerenciador
    studentManager.addStudent("João", 123456L, 7.5);
    studentManager.addStudent("Maria", 123457L, 9.0);
    studentManager.addStudent("Carlos", 123458L, 5.0);
    studentManager.addStudent("Ana", 123459L, 6.8);

    // Exibindo todos os alunos no gerenciador
    System.out.println("Exibindo todos os alunos no gerenciador:");
    System.out.println(studentManager.studentList);

    // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
    System.out.println("\nRemovendo aluno com matrícula inválida:");
    studentManager.removeStudent(000L);
    System.out.println("\nRemovendo aluno com matrícula '123457L' e mostrando alunos restantes:");
    studentManager.removeStudent(123457L);
    System.out.println(studentManager.studentList);

    // Exibindo alunos ordenados por nome
    System.out.println("\nExibindo alunos ordenados por nome:");
    studentManager.showStudentByName();

    // Exibindo alunos ordenados por nota
    System.out.println("\nExibindo alunos ordenados por nota:");
    studentManager.showStudentByScore();
    }
}
