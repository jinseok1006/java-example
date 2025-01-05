package legacy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// 투두리스트 관리 핵심 클래스
public class TodoList {
    List<String> todos = new ArrayList<>();

    public TodoList() {
    }

    public void add(String todo) {
        todos.add(todo);
    }

    public void delete(int num) {
        todos.remove(num-1);
    }

    public void show() {
        AtomicInteger index = new AtomicInteger();
        todos.stream().forEach(todo ->
                System.out.printf("%d. %s\n", index.getAndIncrement()+1, todo)
        );
    }
}
