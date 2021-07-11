package airwallex.element.op;

import airwallex.*;
import airwallex.Number;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
@Scope("prototype")
public class Sqrt extends AbstractOp {

    @Autowired
    public Sqrt(Stack stack) {
        this.stack = stack;
    }

    @Override
    public Number realExecute(List<BigDecimal> params) {
        return NumberDecorator.create(params.get(0).sqrt(Number.mc).toPlainString());
    }

    @Override
    public int getNumberNeed() {
        return 1;
    }
}

