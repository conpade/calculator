package airwallex.element.control;

import airwallex.Log;
import airwallex.element.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Redo extends AbstractControl {
    @Autowired
    Log log;

    @Override
    public void execute() {
        Element e = log.MoveForwardGet();

        // silent or throw exception ?
        if (e != null) {
            e.execute();
        }
    }
}
