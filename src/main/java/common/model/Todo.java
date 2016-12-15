package common.model;

import java.io.Serializable;

public class Todo implements Serializable {

    private String title;

    public Todo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
