package airwallex.element.op;

import airwallex.NumberDecorator;
import airwallex.OpException;
import airwallex.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import airwallex.Number;

import java.math.BigDecimal;
import java.util.List;

@Component
@Scope("prototype")
public class Plus extends AbstractOp {
    @Autowired
    public Plus(Stack stack) {
        this.stack = stack;
    }

    @Override
    public Number realExecute(List<BigDecimal> params) {
        return NumberDecorator.create(params.get(0).add(params.get(1)).toPlainString());
    }

    @Override
    public int getNumberNeed() {
        return 2;
    }
}
