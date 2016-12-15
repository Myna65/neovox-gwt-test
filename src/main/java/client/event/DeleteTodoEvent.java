package client.event;

import com.google.gwt.event.shared.GwtEvent;
import common.model.Todo;

public class DeleteTodoEvent extends GwtEvent<DeleteTodoEventHandler> {

    public static Type<DeleteTodoEventHandler> TYPE = new Type<>();

    Todo todo;

    public Todo getTodo() {
        return todo;
    }

    public DeleteTodoEvent(Todo t) {
        todo = t;
    }

    protected void dispatch(DeleteTodoEventHandler handler) {
        handler.onDeleteTodoEventHandler(this);
    }

    public Type<DeleteTodoEventHandler> getAssociatedType() {
        return TYPE;
    }

}
