package airwallex.calculator.test.control;


import airwallex.calculator.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RedoTest extends BaseTest {
    @Test
    public void test() {
        String res = calculator.input("1 2 undo redo");
        calculator.displayLog();
        Assertions.assertEquals("1 2", res);

    }

    @Test
    public void test2() {
        String res = calculator.input("1 2 undo redo");

        res = calculator.input("3 + undo redo");
        calculator.displayLog();

        Assertions.assertEquals("1 5", res);
    }

    @Test
    public void testMultiRedo() {
        String res = calculator.input("1 2 undo undo");
        calculator.displayLog();
        res = calculator.input("redo redo");
        Assertions.assertEquals("1 2", res);
    }

    @Test
    public void testMultiOp() {
        String res = calculator.input("1 2 undo undo");
        Assertions.assertEquals("", res);

        res = calculator.input("3 3 + 4 + undo undo undo undo");
        Assertions.assertEquals("3", res);

        res = calculator.input("redo redo redo redo");
        Assertions.assertEquals("10", res);
    }

    @Test
    public void testNonOp() {
        String res = calculator.input("1 2 undo undo redo redo redo");

        Assertions.assertEquals("1 2", res);
    }

    @Test
    public void testNonOp2() {
        String res = calculator.input("1 2 redo redo redo");
        Assertions.assertEquals("1 2", res);

        res = calculator.input("undo");
        Assertions.assertEquals("1", res);
    }
}
