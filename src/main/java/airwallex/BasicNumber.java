package airwallex;

import java.math.BigDecimal;

public class BasicNumber implements Number {

    private final String value;

    public BasicNumber(String value) {
        // check format
        new BigDecimal(value);
        this.value = value;
    }

    @Override
    public String display() {
        int pointIndex = value.indexOf(".");
        if (pointIndex > 0) {
            int tailIndex = Math.min(value.length() - 1, pointIndex + 10);

            int targetIndex = pointIndex - 1;
            for (int i = targetIndex + 1; i <= tailIndex; i++) {
                if (value.charAt(i) != '0') {
                    targetIndex = i;
                }
            }

            return value.substring(0, targetIndex + 1);
        }
        return value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
