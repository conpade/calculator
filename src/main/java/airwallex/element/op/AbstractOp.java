package airwallex.element.op;

import airwallex.Number;
import airwallex.OpException;
import airwallex.Stack;
import airwallex.element.NonNumberElement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractOp extends NonNumberElement {
    protected Stack stack;
    protected Number result;

    @Override
    public void execute() {
        if (stack.size() < getNumberNeed()) {
            throw new OpException(this);
        }

        List<BigDecimal> params = new ArrayList<>();
        for (int i = 0; i < getNumberNeed(); i++) {
            params.add(Objects.requireNonNull(stack.pollLast()).getBigDecimal());
        }

        Number res = realExecute(params);
        this.result = res;
        stack.addLast(res);
    }

    public abstract Number realExecute(List<BigDecimal> params);

    public abstract int getNumberNeed();

    public Number getResult() {
        return result;
    }
}
