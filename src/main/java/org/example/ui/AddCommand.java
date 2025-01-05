package org.example.ui;

import org.example.core.TodoService;
import java.util.Scanner;

public class AddCommand implements Command {
    private final TodoService todoService;
    private final Scanner scanner;

    public AddCommand(TodoService todoService, Scanner scanner) {
        this.todoService = todoService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("추가할 내용을 입력하세요: ");
        String todo = scanner.nextLine();
        todoService.addTodo(todo);
    }
}