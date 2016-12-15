package client.ui.schedule;

import client.ui.MainPanel;
import com.google.gwt.core.client.Scheduler;
import common.model.Todo;

import java.util.List;

public class ReloadTodoListCommand implements Scheduler.ScheduledCommand {

    private List<Todo> _todoList;
    private MainPanel _mainPanel;
    private int _index;

    public ReloadTodoListCommand(List<Todo> list, MainPanel mainPanel) {
        _todoList = list;
        _mainPanel = mainPanel;
        _index = 0;
    }

    public void execute() {
        if(_index < _todoList.size()) {
            Todo todo = _todoList.get(_index);
            _mainPanel.addTodoToPanel(todo);
            Scheduler.get().scheduleDeferred(this);
            _index++;
        }
    }
}
