package airwallex.element;

import airwallex.element.control.Clear;
import airwallex.element.control.Redo;
import airwallex.element.control.Undo;
import airwallex.element.op.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NonNumberElementTable {
    private final Map<String, Class<? extends NonNumberElement>> eleMap;

    public Class<? extends NonNumberElement> get(String content){
        return eleMap.get(content);
    }

    public void register(String ele, Class<? extends NonNumberElement> clazz){
        eleMap.put(ele, clazz);
    }

    {
        eleMap = new HashMap<>();
        eleMap.put("+", Plus.class);
        eleMap.put("-", Subtract.class);
        eleMap.put("*", Multiply.class);
        eleMap.put("/", Divide.class);
        eleMap.put("sqrt", Sqrt.class);
        eleMap.put("undo", Undo.class);
        eleMap.put("redo", Redo.class);
        eleMap.put("clear", Clear.class);
    }


}
