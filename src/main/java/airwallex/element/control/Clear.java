package airwallex.element.control;


import airwallex.Log;
import airwallex.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Clear extends AbstractControl {
    @Autowired
    Stack stack;

    @Autowired
    Log log;

    @Override
    public void execute() {
        stack.clear();
        log.clear();
    }
}
