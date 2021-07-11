package airwallex.element.op;

import airwallex.Number;
import airwallex.NumberDecorator;
import airwallex.OpException;
import airwallex.Stack;
import airwallex.element.NonNumberElement;
import airwallex.element.NumberElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Scope("prototype")
public class Divide extends AbstractOp {

    @Autowired
    public Divide(Stack stack) {
        this.stack = stack;
    }

    @Override
    public Number realExecute(List<BigDecimal> params) {
//        BigDecimal n1 = stack.pollLast().getBigDecimal();
//        BigDecimal n2 = stack.pollLast().getBigDecimal();
        return NumberDecorator.create(params.get(1).divide(params.get(0), Number.mc).toPlainString());
    }

    @Override
    public int getNumberNeed() {
        return 2;
    }
}
