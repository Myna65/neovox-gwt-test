package client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddTodoEvent extends GwtEvent<AddTodoEventHandler> {

    public static Type<AddTodoEventHandler> TYPE = new Type<>();

    private String _todoTitle;

    public String getTodoTitle(){
        return _todoTitle;
    }

    public AddTodoEvent(String todoTitle) {
        _todoTitle = todoTitle;
    }

    protected void dispatch(AddTodoEventHandler handler) {
        handler.onAddTodoEventHandler(this);
    }

    public Type<AddTodoEventHandler> getAssociatedType() {
        return TYPE;
    }
}
