package legacy;

import java.util.InputMismatchException;

// TodoList 클래스를 콘솔에 포현하기 위한 콘솔친화 클래스
public class TodoListConsole {
    TodoList todoList;

    public TodoListConsole(TodoList todoList) {
        this.todoList = todoList;
    }

    public void showTodos() {
        todoList.show();
    }

    public void showActivity() {
        System.out.println("==========Todo List===========");
        showTodos();
        System.out.println("==============================");
        System.out.println("1. 추가하기");
        System.out.println("2. 삭제하기");
        System.out.println("3. 종료하기");
    }

    public boolean action() throws Exception {
        var actionNum = getValidatedInput();

        switch (actionNum) {
            case 1:
                System.out.print("추가할 내용을 입력하세요: ");
                var todo = Main.scanner.nextLine();
                todoList.add(todo);
                return true;
            case 2:
                System.out.print("삭제할 번호를 입력하세요: ");
                var num = Main.scanner.nextInt();
                Main.scanner.nextLine(); // 버퍼제거
                todoList.delete(num);
                return true;
            case 3:
                return false;
            default:
                System.out.printf("올바른 입력이 아닙니다(\"%d\")\n", actionNum);
                return true;
        }
    }

    private int getValidatedInput() {
        while (true) {
            System.out.print("어떤 작업을 수행하실 건가요: ");
            try {
                var t = Main.scanner.nextInt();
                Main.scanner.nextLine();
                return t;
            } catch (InputMismatchException e) {
                System.out.println("유효한 숫자를 입력해주세요.");
            }
        }
    }
}