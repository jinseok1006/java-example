package org.example.core;


import java.util.List;

public class TodoService {
    private final ITodoRepository repository;

    public TodoService(ITodoRepository repository) {
        this.repository = repository;
    }

    public void addTodo(String todo) {
        repository.add(todo);
    }

    public void deleteTodo(int index) {
        repository.delete(index);
    }

    public List<String> getTodos() {
        return repository.getAll();
    }
}
