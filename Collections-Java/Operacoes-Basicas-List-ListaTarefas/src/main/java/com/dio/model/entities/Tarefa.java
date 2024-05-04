package com.dio.model.entities;

public class Tarefa {
    
    private String descricao;

    public Tarefa(String descricao) {
        super();
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
