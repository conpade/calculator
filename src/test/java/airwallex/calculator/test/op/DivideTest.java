package airwallex.calculator.test.op;

import airwallex.calculator.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivideTest extends BaseTest {
    @Test
    void testSpecialCase() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.input("0 0 /"));
    }
}
