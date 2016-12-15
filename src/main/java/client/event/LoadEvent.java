package client.event;

import com.google.gwt.event.shared.GwtEvent;

public class LoadEvent extends GwtEvent<LoadEventHandler> {

    public static Type<LoadEventHandler> TYPE = new Type<>();

    @Override
    protected void dispatch(LoadEventHandler handler) {
        handler.onLoadEventHandler(this);
    }

    @Override
    public Type<LoadEventHandler> getAssociatedType() {
        return TYPE;
    }


}
