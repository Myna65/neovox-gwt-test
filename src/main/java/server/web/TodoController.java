package server.web;

import common.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/todos")
public class TodoController {

    private List<Todo> todoList = new ArrayList<>();

    public TodoController() {
        todoList.add(new Todo("Todo #1"));
        todoList.add(new Todo("Todo #2"));
        todoList.add(new Todo("Todo #3"));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> all() {
        return todoList;
    }
}
