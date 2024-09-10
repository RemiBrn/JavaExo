package org.example.springexo01.service;

import org.example.springexo01.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    private final List<ToDo> todos = new ArrayList<>();

    public ToDoService() {
        todos.add(new ToDo("Exemple_1", "Description 1", false));
        todos.add(new ToDo("Exemple_2", "Description 2", true));
    }

    public List<ToDo> getAllTodos() {
        return todos;
    }

    public ToDo getOneTodo(String name) {
        for (ToDo todo : todos) {
            if (todo.getName().equalsIgnoreCase(name)) {
                return todo;
            }
        }
        return null;
    }
}
