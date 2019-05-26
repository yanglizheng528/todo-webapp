package com.ylz.gradle.todo.repository;

import com.ylz.gradle.todo.model.ToDoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Lenovo
 * @version v1.0
 * @date 2019/5/19
 * @description TODO
 */
public class InMemoryToDoRepository implements ToDoRepository {
    private AtomicLong currentId = new AtomicLong();
    private ConcurrentMap<Long, ToDoItem> todoMap = new ConcurrentHashMap<>();

    @Override
    public List<ToDoItem> findAll() {
        List<ToDoItem> toDoItemList = new ArrayList<>(todoMap.values());
        Collections.sort(toDoItemList);
        return toDoItemList;
    }

    @Override
    public ToDoItem findById(Long id) {
        return todoMap.getOrDefault(id, null);
    }

    @Override
    public Long insert(ToDoItem toDoItem) {
        Long id = currentId.incrementAndGet();
        toDoItem.setId(id);
        todoMap.putIfAbsent(id, toDoItem);
        return id;
    }

    @Override
    public void update(ToDoItem toDoItem) {
        todoMap.replace(toDoItem.getId(), toDoItem);
    }

    @Override
    public void delete(ToDoItem toDoItem) {
        todoMap.remove(toDoItem.getId());
    }
}
