package org.example.infrastructure;

import org.example.core.ITodoRepository;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTodoRepository implements ITodoRepository {
    private final List<String> todos = new ArrayList<>();

    @Override
    public void add(String todo) {
        todos.add(todo);
    }

    @Override
    public void delete(int num) {
        todos.remove(num - 1);
    }

    @Override
    public List<String> getAll() {
        return new ArrayList<>(todos); // 변경 방지
    }
}
