package client.event;

import com.google.gwt.event.shared.GwtEvent;

public class DeleteAllTodoEvent extends GwtEvent<DeleteAllTodoEventHandler> {

    public static Type<DeleteAllTodoEventHandler> TYPE = new Type<>();

    protected void dispatch(DeleteAllTodoEventHandler handler) {
        handler.onDeleteAllTodoEventHandler(this);
    }

    public Type<DeleteAllTodoEventHandler> getAssociatedType() {
        return TYPE;
    }


}
