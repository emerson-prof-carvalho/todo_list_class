package br.edu.ifsuldeminas.mch.tarefas.domain;

public class Task {
    private Integer id;
    private String description;
    private boolean active;

    public Task(Integer id, String description){
        this.id = id;
        this.description = description;
        active = true;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
