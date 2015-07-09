package primerenizpit;

public class EncMessage extends Message{

    private int key;
    private String txt;

    public EncMessage(int key, String txt, String source, String destination) {
        super(source, destination);
        this.setKey(key);
        this.setTxt(txt);
    }

    public EncMessage() {
        this(0, "", "", "");
    }

    public EncMessage(EncMessage encMessage) {
        this(encMessage.key, encMessage.txt, encMessage.getSource(), encMessage.getDestination());
    }

    public String getTxt() {
        return decrypt(txt);
    }

    public void setTxt(String txt) {
        this.txt = encrypt(txt);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String encrypt(String text) {
        char[] chrArray = text.toCharArray();
        char[] encArray = new char[chrArray.length];
        
        for (int i = 0; i < chrArray.length; i++) {
            encArray[i] = chrArray[(i + key) % chrArray.length];
        }

        return new String(encArray);
    }
    
    public String decrypt(String text) {
        char[] encArray = text.toCharArray();
        char[] chrArray = new char[encArray.length];
        
        for (int i = 0; i < encArray.length; i++) {
            chrArray[i] = encArray[(i - key + encArray.length) % encArray.length];
        }

        return new String(chrArray);
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

    @Override
    public String toString() {
        return "EncMessage{" + "key=" + key + ", txt=" + txt + '}';
    }

}
