package org.example.ui;

import org.example.core.TodoService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoListConsole {
    private final Map<Integer, Command> commands = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private final TodoService todoService;

    public TodoListConsole(TodoService todoService) {
        this.todoService = todoService;
        commands.put(1, new AddCommand(todoService, scanner));
        commands.put(2, new DeleteCommand(todoService, scanner));
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
        var loop = true;
        while (loop) {
            showActivity();
            var choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 제거
            var command = commands.get(choice);

            if (choice == 3) { // 종료하기
                loop = false;
                continue;
            }

            if (command == null) {
                System.out.println("유효한 선택이 아닙니다.");
                continue;
            }

            command.execute();
        }
    }
}

