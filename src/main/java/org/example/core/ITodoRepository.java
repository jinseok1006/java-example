package org.example.core;

import java.util.List;

public interface ITodoRepository {
    void add(String todo);
    void delete(int num);
    List<String> getAll();
}
