package com.ylz.gradle.todo.repository;

import com.ylz.gradle.todo.model.ToDoItem;

import java.util.List;

/**
 * @author Lenovo
 * @version v1.0
 * @date 2019/5/19
 * @description TODO
 */
public interface ToDoRepository {
    List<ToDoItem> findAll();

    ToDoItem findById(Long id);

    Long insert(ToDoItem toDoItem);

    void update(ToDoItem toDoItem);

    void delete(ToDoItem toDoItem);
}
