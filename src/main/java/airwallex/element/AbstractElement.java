package airwallex.element;

public class AbstractElement implements Element {
    protected String content;

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void execute() {
        throw new UnsupportedOperationException();
    }
}
