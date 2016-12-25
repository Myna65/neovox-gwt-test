package client;

import client.controller.WebAppController;
import client.resource.ApplicationResources;
import client.ui.MainPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class GwtWebApp implements EntryPoint {

    private final GwtWebAppGinjector injector =GWT.create(GwtWebAppGinjector.class);

    public void onModuleLoad() {
        ApplicationResources.INSTANCE.style().ensureInjected();
        WebAppController controller = injector.getWebAppController();

        controller.bindHandlers();

        MainPanel mainPanel = injector.getMainPanel();

        RootLayoutPanel.get().add(mainPanel);
    }


}
