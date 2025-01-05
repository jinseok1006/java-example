package legacy;

import java.util.Scanner;


public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        var todoList = new TodoList();
        var todoListConsole = new TodoListConsole(todoList);

        boolean loop = true;
        while (loop) {
            todoListConsole.showActivity();
            loop = todoListConsole.action();
            clearConsole();
        }
        System.out.println("종료합니다...");
        scanner.close();
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
//        System.out.flush();
    }
}







