package org.example;

import org.example.core.TodoService;
import org.example.infrastructure.InMemoryTodoRepository;
import org.example.ui.TodoListConsole;

public class Main {
    public static void main(String[] args) {
        var repository = new InMemoryTodoRepository();
        var service = new TodoService(repository);
        var console = new TodoListConsole(service);
        console.run();
    }
}
