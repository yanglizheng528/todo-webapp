package com.ylz.gradle.todo.model;

/**
 * @author Lenovo
 * @version v1.0
 * @date 2019/5/19
 * @description TODO
 */
public class ToDoItem implements Comparable<ToDoItem>{
    private Long id;
    private String name;
    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int compareTo(ToDoItem other) {
        if(this == other){
            return 0;
        }
        if(this.id > other.id){
            return 1;
        }
        if(this.id.equals(other.id)){
            return 0;
        }
        if(this.id > other.id){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", completed=" + completed +
                '}';
    }
}

