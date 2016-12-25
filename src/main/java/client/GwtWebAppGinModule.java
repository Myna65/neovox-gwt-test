package client;

import client.controller.WebAppController;
import client.model.ModelHandler;
import client.resource.ApplicationResources;
import client.resource.Messages;
import client.ui.MainPanel;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class GwtWebAppGinModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(Messages.class).in(Singleton.class);
        bind(ApplicationResources.class).in(Singleton.class);

        bind(SimpleEventBus.class).in(Singleton.class);
        bind(WebAppController.class).in(Singleton.class);
        bind(ModelHandler.class).in(Singleton.class);

        bind(MainPanel.class).in(Singleton.class);
    }
}
