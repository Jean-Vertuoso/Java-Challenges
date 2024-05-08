package com.dio.model.entities;

public class Task {
    
    private String description;

    public Task(String description) {
        super();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
