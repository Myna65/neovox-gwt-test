package client.ui;

import client.event.AddTodoEvent;
import client.event.DeleteAllTodoEvent;
import client.event.LoadEvent;
import client.model.ModelHandler;
import client.ui.component.ImageButton;
import client.ui.schedule.ReloadTodoListCommand;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import common.model.Todo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPanel extends Composite {
    private static MainPanelUiBinder uiBinder = GWT.create(MainPanelUiBinder.class);

    interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {

    }

    @UiField
    ImageButton addButton;

    @UiField
    ImageButton clearButton;

    @UiField
    ImageButton loadButton;

    @UiField
    TextBox textBox;

    @UiField
    FlowPanel todoPanel;

    private Map<String, TodoWidget> _todoWidgets;

    private SimpleEventBus _eventBus;

    private ModelHandler _modelHandler;

    @Inject
    public MainPanel(SimpleEventBus eventBus, ModelHandler modelHandler) {
        _eventBus = eventBus;
        initWidget(uiBinder.createAndBindUi(this));
        _todoWidgets = new HashMap<>();
        _modelHandler = modelHandler;
    }

    @UiHandler("addButton")
    void onAddButtonClick(ClickEvent e) {
        String todoText = textBox.getText();
        _eventBus.fireEvent(new AddTodoEvent(todoText));
    }

    @UiHandler("clearButton")
    void onClearButtonClick(ClickEvent e) {
        _eventBus.fireEvent(new DeleteAllTodoEvent());
    }

    @UiHandler("loadButton")
    void onLoadButtonClick(ClickEvent e) {
        _eventBus.fireEvent(new LoadEvent());
    }

    public void addTodoToPanel(Todo t) {
        if(_todoWidgets.get(t.getTitle()) == null) {
            TodoWidget w =new TodoWidget(t, _eventBus);
            todoPanel.add(w);
            _todoWidgets.put(t.getTitle(), w);
        } else {
            Window.alert("Already existing Todo: "+t.getTitle());
        }
    }

    public void removeTodoPanel(Todo t) {
        TodoWidget todoWidget = _todoWidgets.get(t.getTitle());
        todoPanel.remove(todoWidget);
        _todoWidgets.remove(t.getTitle());
    }

    public void removeAllTodo() {
        todoPanel.clear();
        _todoWidgets.clear();
    }

    public void reloadTodoList() {
        removeAllTodo();
        List<Todo> all = _modelHandler.getAll();

        if(all.size() > 0) {
            ReloadTodoListCommand reloadCommand = new ReloadTodoListCommand(all, this);
            Scheduler.get().scheduleDeferred(reloadCommand);
        }
    }


}
