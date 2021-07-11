package airwallex.calculator.test.control;

import airwallex.calculator.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UndoTest extends BaseTest {

    @Test
    public void test() {
        String res = calculator.input("1 2 undo");
        Assertions.assertEquals("1", res);

        res = calculator.input("3 + undo");
        Assertions.assertEquals("1 3", res);
    }

    @Test
    public void testMulti() {
        String res = calculator.input("1 2 undo undo");
        Assertions.assertEquals("", res);

        res = calculator.input("3 3 + undo undo");
        Assertions.assertEquals("3", res);
    }

    @Test
    public void testMultiOp() {
        String res = calculator.input("1 2 undo undo");
        Assertions.assertEquals("", res);

        res = calculator.input("3 3 + 4 + undo undo undo undo");
        Assertions.assertEquals("3", res);
    }

    @Test
    public void testNonOp() {
        String res = calculator.input("1 2 undo undo undo");
        calculator.displayLog();
        Assertions.assertEquals("", res);

        res = calculator.input("3 4 + undo undo undo undo");
        Assertions.assertEquals("", res);
    }

    @Test
    public void testNonOp2() {
        String res = calculator.input("undo undo");
        calculator.displayLog();
        Assertions.assertEquals("", res);

        res = calculator.input("3 4 + undo undo undo undo");
        Assertions.assertEquals("", res);
    }
}
