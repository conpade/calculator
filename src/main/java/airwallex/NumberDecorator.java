package airwallex;

public class NumberDecorator implements Number {

    private final BasicNumber basicNumber;

    public NumberDecorator(BasicNumber basicNumber) {
        this.basicNumber = basicNumber;
    }

    public static NumberDecorator create(String value) {
        return new NumberDecorator(new BasicNumber(value));
    }

    @Override
    public String getValue() {
        return basicNumber.getValue();
    }

    @Override
    public String display() {
        // todo
        return basicNumber.display();
    }
}
