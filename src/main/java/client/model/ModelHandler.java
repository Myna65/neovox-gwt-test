package client.model;

import common.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class ModelHandler {

    List<Todo> todoList;

    public ModelHandler() {
        todoList = new ArrayList<>();
    }

    public void add(Todo t) {
        todoList.add(t);
    }

    public void remove(Todo t) {
        todoList.remove(t);
    }

    public void removeAll() {
        todoList.clear();
    }

    public List<Todo> getAll() {
        return todoList;
    }

    public void reloadAll(List<Todo> list) {
        todoList.clear();
        for (Todo t : list) {
            add(t);
        }
    }
}
