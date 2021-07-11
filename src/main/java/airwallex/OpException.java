package airwallex;

import airwallex.element.Element;

public class OpException extends RuntimeException{
    private Element element;

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public OpException(Element element) {
        this.element = element;
    }
}
