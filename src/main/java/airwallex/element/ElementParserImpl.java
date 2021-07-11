package airwallex.element;

import airwallex.BasicNumber;
import airwallex.NumberDecorator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElementParserImpl implements ElementParser {
    @Autowired
    NonNumberElementTable nonNumberElementTable;
    @Autowired
    BeanFactory beanFactory;

    @Override
    public Element parse(String content) {
        Class<? extends NonNumberElement> clazz = nonNumberElementTable.get(content);
        if (clazz != null) {
            NonNumberElement op = beanFactory.getBean(clazz);
            op.setContent(content);
            return op;
        }

        NumberElement numberElement = beanFactory.getBean(NumberElement.class);
        numberElement.setNumber(new NumberDecorator(new BasicNumber(content)));
        return numberElement;
    }


}
