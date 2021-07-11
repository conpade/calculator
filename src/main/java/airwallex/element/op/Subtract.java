package airwallex.element.op;

import airwallex.Number;
import airwallex.NumberDecorator;
import airwallex.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Scope("prototype")
public class Subtract extends AbstractOp {
    @Autowired
    public Subtract(Stack stack) {
        this.stack = stack;
    }

    @Override
    public Number realExecute(List<BigDecimal> params) {
        return NumberDecorator.create(params.get(1).subtract(params.get(0)).toPlainString());
    }

    @Override
    public int getNumberNeed() {
        return 2;
    }
}
