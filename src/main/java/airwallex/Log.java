package airwallex;

import airwallex.element.Element;
import airwallex.element.control.AbstractControl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import java.util.List;

@Component
public class Log {

    List<Element> elements = new ArrayList<>();
    private int pointer = -1;

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public Element get(int index) {
        return elements.get(index);
    }

    public Element MoveForwardGet() {
        if (pointer >= elements.size() - 1) {
            return null;
        }
        return elements.get(++pointer);
    }

    public Element getMoveBackward() {
        if (pointer < 0) {
            return null;
        }
        return elements.get(pointer--);
    }

    public void add(Element e) {
        if (e instanceof AbstractControl) {
            return;
        }
        if (pointer < elements.size() - 1) {
            elements = elements.subList(0, pointer + 1);
        }
        elements.add(e);
        pointer = elements.size() - 1;
    }

    public void clear() {
        elements.clear();
        pointer = -1;
    }

    public void display() {
        this.elements.forEach(e -> System.out.print(e.getContent() + " "));
        System.out.printf(" pointer %s", pointer);
        System.out.println();
    }
}
