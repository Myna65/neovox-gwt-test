package client;

import client.controller.WebAppController;
import client.model.ModelHandler;
import client.resources.ApplicationResources;
import client.resources.Messages;
import client.ui.MainPanel;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(GwtWebAppGinModule.class)
public interface GwtWebAppGinjector extends Ginjector {

    public SimpleEventBus getEventBus();

    public ApplicationResources getApplicationResources();

    public Messages getMessages();

    public WebAppController getWebAppController();

    public ModelHandler getModelHandler();

    public MainPanel getMainPanel();

}
