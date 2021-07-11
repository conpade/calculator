package airwallex;

import java.math.BigDecimal;
import java.math.MathContext;

public interface Number {
    MathContext mc = MathContext.DECIMAL128;
    default BigDecimal getBigDecimal(){
        return new BigDecimal(getValue(), mc);
    }
    String getValue();
    String display();
}
