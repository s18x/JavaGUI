package primerenizpit;

public class TextMessage extends Message {

    private String txt;

    public TextMessage(String txt, String source, String destination) {
        super(source, destination);
        this.txt = txt;
    }

    public TextMessage() {
        this("", "", "");
    }

    public TextMessage(TextMessage text) {
        this(text.txt, text.getSource(), text.getDestination());
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "TextMessage{" + "txt=" + txt + '}';
    }

    @Override
    public void appendTo(Appendable obj) {
        TextMessage textMessage = new TextMessage();
        EncMessage encMessage = new EncMessage();
        if (obj instanceof TextMessage) {
            textMessage.setTxt(textMessage.getTxt() + "" + this.txt);
            textMessage.setSource(textMessage.getSource() + "" + this.getSource());
            textMessage.setDestination(textMessage.getDestination() + "" + this.getDestination());
        }
        if (obj instanceof EncMessage) {
            encMessage.setTxt(encMessage.getTxt() + "" + this.txt);
            encMessage.setSource(encMessage.getSource() + "" + this.getSource());
            encMessage.setDestination(encMessage.getDestination() + "" + this.getDestination());
        }
    }

}
