package org.example.ui;

import org.example.core.TodoService;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoListConsole {
    private final TodoService todoService;
    private final Scanner scanner = new Scanner(System.in);

    public TodoListConsole(TodoService todoService) {
        this.todoService = todoService;
    }

    public void showActivity() {
        var atomicInteger = new AtomicInteger();
        System.out.println("========== Todo List ===========");
        todoService.getTodos().forEach((todo) ->
                System.out.printf("%d. %s\n", atomicInteger.getAndIncrement() + 1, todo)
        );
        System.out.println("================================");
        System.out.println("1. 추가하기");
        System.out.println("2. 삭제하기");
        System.out.println("3. 종료하기");
    }

    public void run() {
        boolean loop = true;
        while (loop) {
            showActivity();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 제거
            switch (choice) {
                case 1 -> {
                    System.out.print("추가할 내용을 입력하세요: ");
                    String todo = scanner.nextLine();
                    todoService.addTodo(todo);
                }
                case 2 -> {
                    System.out.print("삭제할 번호를 입력하세요: ");
                    int index = scanner.nextInt();
                    todoService.deleteTodo(index);
                }
                case 3 -> loop = false;
                default -> System.out.println("유효한 선택이 아닙니다.");
            }
        }
    }
}

