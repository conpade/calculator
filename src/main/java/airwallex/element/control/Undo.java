package airwallex.element.control;

import airwallex.Log;
import airwallex.Stack;
import airwallex.element.Element;
import airwallex.element.NumberElement;
import airwallex.element.op.AbstractOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Undo extends AbstractControl {
    @Autowired
    Log log;
    @Autowired
    Stack stack;

    @Override
    public void execute() {
        Element e = log.getMoveBackward();

        // silent or throw exception ?
        if (e != null) {
            stack.removeLast();
            if (e instanceof AbstractOp) {
                int start = log.getPointer() - ((AbstractOp) e).getNumberNeed() + 1;
                for (int i = start; i <= log.getPointer(); i++) {
                    Element curEle = log.get(i);
                    if (curEle instanceof NumberElement) {
                        stack.addLast(((NumberElement) curEle).getNumber());
                    } else {
                        stack.addLast(((AbstractOp) curEle).getResult());
                    }
                }
            }
        }
    }

}
