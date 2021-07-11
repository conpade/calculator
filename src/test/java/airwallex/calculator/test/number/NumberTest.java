package airwallex.calculator.test.number;


import airwallex.calculator.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class NumberTest extends BaseTest {

    @Test
    void testPrecision() {
        String res = calculator.input("10000000000000000000000.0000000005 10000000000000000000000.000000000000000000005 +");
        Assertions.assertEquals("20000000000000000000000.0000000005", res);
    }

    @Test
    void testPrecision2() {
        String res = calculator.input("10000000000000000000000.00000000005 10000000000000000000000.00000000005 +");
        Assertions.assertEquals("20000000000000000000000.0000000001", res);
    }

    @Test
    void testFormat() {
        Assertions.assertThrows(NumberFormatException.class, () -> calculator.input("10000000000.000000000000.00000000005"));
    }

    @Test
    void testFormat2() {
        Assertions.assertThrows(NumberFormatException.class, () -> calculator.input("10000000000aa000000000000.00000000005"));
    }

    @Test
    void testFormat3() {
        Assertions.assertThrows(NumberFormatException.class, () -> calculator.input("1000000000000..00000000005"));
    }
}