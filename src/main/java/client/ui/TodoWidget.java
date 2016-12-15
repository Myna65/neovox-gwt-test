package client.ui;

import client.event.DeleteTodoEvent;
import client.ui.component.ImageButton;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;
import common.model.Todo;

public class TodoWidget extends Composite {

    private static TodoWidgetUiBinder uiBinder = GWT.create(TodoWidgetUiBinder.class);

    interface TodoWidgetUiBinder extends UiBinder<Widget, TodoWidget> {

    }

    @UiField
    ImageButton deleteButton;

    @UiField
    InlineLabel textBox;

    private Todo currentTodo;

    private SimpleEventBus _eventBus;

    public TodoWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public TodoWidget(Todo t, SimpleEventBus eventBus) {
        _eventBus = eventBus;
        initWidget(uiBinder.createAndBindUi(this));
        this.currentTodo = t;
        textBox.setText(t.getTitle());
    }

    @UiHandler("deleteButton")
    @SuppressWarnings("unused")
    void onAddButtonClick(ClickEvent e) {
        boolean confirm = Window.confirm("Delete " + currentTodo.getTitle() + "?");
        if (confirm) {
            _eventBus.fireEvent(new DeleteTodoEvent(currentTodo));
        }
    }

}
