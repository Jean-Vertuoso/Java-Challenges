package com.dio.model.entities;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    //attributes
    private List<Task> taskList;    
    
    //constructor
    public TaskList() {
        this.taskList = new ArrayList<>();
    }
    
    public void addTask(String description){
        taskList.add(new Task(description));
    }
    
    public void removeTask(String description){
        List<Task> taskToRemove = new ArrayList<>();
        if(!taskList.isEmpty()){
            for (Task t : taskList) {
                if(t.getDescription().equalsIgnoreCase(description)){
                    taskToRemove.add(t);
                }
            }
            taskList.removeAll(taskToRemove);
        } else {
          System.out.println("A lista está vazia!");
        }
    }
    
    public int getTotalNumberTask(){
        return taskList.size();
    }
    
    public void getDescriptionsTask(){
        if (!taskList.isEmpty()) {
            System.out.println(taskList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefa
        TaskList taskList = new TaskList();
        
        // Adicionando tarefas à lista
        taskList.addTask("Comprar leite");
        taskList.addTask("Estudar para o exame");
        taskList.addTask("Fazer exercícios");
        
        // Exibindo o número total de tarefas na lista
        System.out.println("Você tem " + taskList.getTotalNumberTask() + " tarefas na lista:");
        
        // Exibindo as descrições das tarefas na lista
        taskList.getDescriptionsTask();

        // Removendo uma tarefa da lista
        taskList.removeTask("Trabalhar");

        // Exibindo o número total de tarefas na lista após a remoção
        System.out.println("Agora você tem " + taskList.getTotalNumberTask() + " tarefas na lista:");

        // Exibindo as descrições das tarefas atualizadas na lista
        taskList.getDescriptionsTask();

        // Removendo uma tarefa da lista quando a lista está vazia
        taskList.removeTask("Estudar para o exame");

        // Exibindo o número total de tarefas na lista após tentar remover de uma lista vazia
        System.out.println("Agora você tem " + taskList.getTotalNumberTask() + " tarefas na lista:");
    }
}
