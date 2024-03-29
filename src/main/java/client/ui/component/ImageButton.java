package client.ui.component;

import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;

public class ImageButton extends Button {
    private String text;

    public ImageButton() {
        super();
    }

    public void setResource(ImageResource imageResource) {
        Image img = new Image(imageResource);
        String definedStyles = img.getElement().getAttribute("style");
        img.getElement().setAttribute("style", definedStyles + "; vertical-align:middle;");
        DOM.insertBefore(getElement(), img.getElement(), DOM.getFirstChild(getElement()));
    }

    public void setText(String text) {
        this.text = text;
        Element span = DOM.createSpan();
        span.setInnerText(text);
        span.setAttribute("style", "padding-left: 3px; vertical-align:middle");
        DOM.insertChild(getElement(), span, 0);
    }

    public String getText() {
        return text;
    }
}
