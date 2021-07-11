package airwallex.calculator.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommonCase extends BaseTest{
    @Test
    public void test1(){
        String res = calculator.input("5 2");
        Assertions.assertEquals("5 2", res);
    }

    @Test
    public void test2(){
        String res = calculator.input("2 sqrt");
        Assertions.assertEquals("1.4142135623", res);

        res = calculator.input("clear 9 sqrt");
        Assertions.assertEquals("3", res);
    }

    @Test
    public void test3(){
        String res = calculator.input("5 2 -");
        Assertions.assertEquals("3", res);

        res = calculator.input("3 -");
        Assertions.assertEquals("0", res);

        res = calculator.input("clear");
        Assertions.assertEquals("", res);
    }

    @Test
    public void test4(){
        String res = calculator.input("5 4 3 2");
        Assertions.assertEquals("5 4 3 2", res);

        res = calculator.input("undo undo *");
        Assertions.assertEquals("20", res);

        res = calculator.input("5 *");
        Assertions.assertEquals("100", res);

        res = calculator.input("undo");
        Assertions.assertEquals("20 5", res);
    }

    @Test
    public void test5(){
        String res = calculator.input("7 12 2 /");
        Assertions.assertEquals("7 6", res);

        res = calculator.input("*");
        Assertions.assertEquals("42", res);

        res = calculator.input("4 /");
        Assertions.assertEquals("10.5", res);
    }

    @Test
    public void test6(){
        String res = calculator.input("1 2 3 4 5");
        Assertions.assertEquals("1 2 3 4 5", res);

        res = calculator.input("*");
        Assertions.assertEquals("1 2 3 20", res);

        res = calculator.input("clear 3 4 -");
        Assertions.assertEquals("-1", res);
    }

    @Test
    public void test7(){
        String res = calculator.input("1 2 3 4 5");
        Assertions.assertEquals("1 2 3 4 5", res);

        res = calculator.input("* * * *");
        Assertions.assertEquals("120", res);
    }

    @Test
    public void test8(){
        String res = calculator.input("1 2 3 * 5 + * * 6 5");
        Assertions.assertEquals("11", res);
    }
}
