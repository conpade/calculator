package airwallex;

import airwallex.element.Element;
import airwallex.element.ElementParser;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

    private final ElementParser elementParser;
    private final Stack stack;
    private final Log log;

    public Calculator(ElementParser elementParser, Stack stack, Log log) {
        this.elementParser = elementParser;
        this.stack = stack;
        this.log = log;
    }

    public String input(String input) {
        if (input.length() == 0) {
            return "";
        }

        input += " ";
        StringBuilder sb = new StringBuilder();
        int position = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                if (sb.length() != 0) {

                    Element e = elementParser.parse(sb.toString());

                    try {
                        e.execute();
                    } catch (OpException exception) {
                        System.out.printf("operator %s (position: %s): insufficient parameters%n", e.getContent(), position);
                        break;
                    }
                    log.add(e);
                    sb = new StringBuilder();
                }
            } else {
                if (sb.length() == 0) {
                    position = i + 1;
                }
                sb.append(input.charAt(i));
            }

        }

        return displayStack();
    }


    public String displayStack() {
        if (stack.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(e -> sb.append(e.display()).append(" "));
        String ret = sb.substring(0, sb.length() - 1);
        System.out.println(ret);
        return ret;
    }

    public void displayLog(){
        log.display();
    }
}
