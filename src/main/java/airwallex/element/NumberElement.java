package airwallex.element;

import airwallex.*;
import airwallex.Number;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NumberElement implements Element {
    private final Stack stack;
    private final Log log;

    private Number number;

    @Autowired
    public NumberElement(Stack stack, Log log) {
        this.stack = stack;
        this.log = log;
    }

    @Override
    public void execute() {
        stack.addLast(number);
    }

    @Override
    public String getContent() {
        return number.getValue();
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
}
