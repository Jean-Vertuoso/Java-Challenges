package com.dio.model.entities;

import java.util.HashSet;
import java.util.Set;

public class Tasklist {
    //attributes
    private Set<Task> taskList = new HashSet<>();   
    
    //constructor
    public Tasklist() {}
    
    public void addTask(String description){
        taskList.add(new Task(description));
    }
    
    public void removeTask(String description){
        Task taskToRemove = null;
        if(!taskList.isEmpty()){
            for (Task task : taskList) {
                if(task.getDescription().equalsIgnoreCase(description)){
                    taskToRemove = task;
                    break;
                }
            }
            taskList.remove(taskToRemove);
        } else {
          System.out.println("A lista de tarefas está vazia!");
        }
        
        if(taskToRemove == null){
            System.out.println("Tarefa não encontrada!");
        }
    }
    
    public void showTasks(){
        if (true) {            
            System.out.println(taskList);
        } else {
            System.out.println("A lista de tarefas está vazia!");
        }
    }
    
    public Set<Task> getCompletedTasks(){
        Set<Task> completedTasks = new HashSet<>();
        for (Task task : taskList) {
            if (task.getDone()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }
    
    public Set<Task> getPendingTasks(){
        Set<Task> pendingTasks = new HashSet<>();
        for (Task task : taskList) {
            if (!task.getDone()) {
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }
    
    public void markAsComplete(String description){
        for (Task toMark : taskList) {
            if (toMark.getDescription().equalsIgnoreCase(description)) {
                toMark.setDone(true);
                break;
            }
        }
    }
    
    public void markAsPending(String description){
        for (Task toMark : taskList) {
            if (toMark.getDescription().equalsIgnoreCase(description)) {
                toMark.setDone(false);
            }
        }
    }
    
    public void dropList(){
        if (taskList.isEmpty()) {
            System.out.println("A lista já está vazia!");
        } else {
            taskList.clear();
        }
    }
    
    public void countTasks(){        
        System.out.println("A lista possui "+ taskList.size() +" tarefas.");
    }
    
    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefa
        Tasklist taskList = new Tasklist();
        
        // Adicionando tarefas à lista
        taskList.addTask("Estudar Java");
        taskList.addTask("Fazer exercícios físicos");
        taskList.addTask("Organizar a mesa de trabalho");
        taskList.addTask("Ler livro");
        taskList.addTask("Preparar apresentação");
        
        // Exibindo as tarefas na lista
        System.out.println("Exibindo as tarefas na lista: ");        
        taskList.showTasks();

        // Removendo uma tarefa
        System.out.println("\nRemovendo a tarefa 'Fazer exercícios físicos': ");
        taskList.removeTask("Fazer exercícios físicos");
        taskList.showTasks();

        // Contando o número de tarefas na lista
        System.out.print("\nTotal de tarefas na lista: ");
        taskList.countTasks();

        // Obtendo tarefas pendentes
        System.out.println("\nObtendo tarefas pendentes: ");
        System.out.println(taskList.getPendingTasks());

        // Marcando tarefas como concluídas
        taskList.markAsComplete("Ler livro");
        taskList.markAsComplete("Estudar Java");

        System.out.println("\nObtendo tarefas concluídas:");
        // Obtendo tarefas concluídas
        System.out.println(taskList.getCompletedTasks());

        // Marcando tarefas como pendentes
        System.out.println("\nMarcando 'Estudar Java' como pendente e mostrando lista de tarefas pendentes:");
        taskList.markAsPending("Estudar Java");
        taskList.showTasks();

        // Limpando a lista de tarefas
        System.out.println("\nMostrando lista vazia:");
        taskList.dropList();
        taskList.showTasks();
    }
}
