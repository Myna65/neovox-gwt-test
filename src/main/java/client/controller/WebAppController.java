package client.controller;

import client.event.*;
import client.json.JsonHelper;
import client.model.ModelHandler;
import client.ui.MainPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import common.model.Todo;

import java.util.List;

public class WebAppController {

    private SimpleEventBus _eventBus;

    private ModelHandler _modelHandler;

    private MainPanel _mainPanel;

    @Inject
    public WebAppController(SimpleEventBus eventBus, ModelHandler modelHandler, MainPanel mainPanel) {
        _eventBus=eventBus;
        _modelHandler=modelHandler;
        _mainPanel=mainPanel;
    }

    public void bindHandlers() {
        _eventBus.addHandler(AddTodoEvent.TYPE, new AddTodoEventHandler() {
            @Override
            public void onAddTodoEventHandler(AddTodoEvent event) {
                addTodo(event.getTodoTitle());
            }
        });

        _eventBus.addHandler(DeleteAllTodoEvent.TYPE, new DeleteAllTodoEventHandler() {
            @Override
            public void onDeleteAllTodoEventHandler(DeleteAllTodoEvent event) {
                deleteAll();
            }
        });

        _eventBus.addHandler(DeleteTodoEvent.TYPE, new DeleteTodoEventHandler() {
            @Override
            public void onDeleteTodoEventHandler(DeleteTodoEvent event) {
                deleteTodo(event.getTodo());
            }
        });

        _eventBus.addHandler(LoadEvent.TYPE, new LoadEventHandler() {
            @Override
            public void onLoadEventHandler(LoadEvent event) {
                loadTodoList();
            }
        });
    }

    protected void reloadList(List<Todo> list) {
        _modelHandler.reloadAll(list);
        _mainPanel.reloadTodoList();
    }

    protected void loadTodoList() {
        String pageBaseUrl = GWT.getHostPageBaseURL();
        RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, pageBaseUrl+"/rest/todos/");
        rb.setCallback(new RequestCallback() {
            @Override
            public void onResponseReceived(Request request, Response response) {
                if(200==response.getStatusCode()) {
                    String text = response.getText();
                    System.out.println("text = "+text);
                    Window.alert("response = "+text);
                    List<Todo> todoList = JsonHelper.parseDataList(text);
                    reloadList(todoList);
                }
            }

            @Override
            public void onError(Request request, Throwable exception) {
                Window.alert("error "+ exception.getMessage());
            }
        });

        try {
            rb.send();
        } catch (RequestException e) {
            e.printStackTrace();
            Window.alert("error = "+e.getMessage());
        }
    }

    protected void deleteAll() {
        _modelHandler.removeAll();
        _mainPanel.removeAllTodo();
    }

    protected void deleteTodo(Todo todo) {
        _modelHandler.remove(todo);
    }

    protected void addTodo(String todoTitle) {
        Todo t = new Todo(todoTitle);
        _modelHandler.add(t);
        _mainPanel.addTodoToPanel(t);
    }
}
