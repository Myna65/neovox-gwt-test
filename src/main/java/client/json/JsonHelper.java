package client.json;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import common.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    @SuppressWarnings("unchecked")
    public static List<Todo> parseDataList(String json) {
        List<Todo> todoList = new ArrayList<>();
        JSONValue jsonValue = JSONParser.parseStrict(json);
        JSONArray object = jsonValue.isArray();
        JsArray<JsTodo> array = (JsArray<JsTodo>) object.getJavaScriptObject();
        if(array != null) {
            for(int i =0;i<array.length();i++) {
                JsTodo jsTodo = array.get(i);
                String title = jsTodo.title();
                todoList.add(new Todo(title));
            }
        }
        return todoList;
    }
}
