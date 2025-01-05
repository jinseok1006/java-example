package org.example.ui;

import org.example.core.TodoService;
import java.util.Scanner;

public class DeleteCommand implements Command {
    private final TodoService todoService;
    private final Scanner scanner;

    public DeleteCommand(TodoService todoService, Scanner scanner) {
        this.todoService = todoService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("삭제할 번호를 입력하세요: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // 버퍼 제거
        todoService.deleteTodo(index);
    }
}