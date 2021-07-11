package airwallex.calculator.test;

import airwallex.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TestConfiguration.class})
public abstract class BaseTest {
    @Autowired
    protected Calculator calculator;

    @BeforeEach
    public void resetCalculator(){
        calculator.input("clear");
    }
}
