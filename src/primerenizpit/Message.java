package primerenizpit;

public abstract class Message implements Appendable{

    private String source;
    private String destination;
    private final int MESSAGE_ID;
    private static int messageCounter = 0;

    public Message(String source, String destination) {
        this();
        this.setSource(source);
        this.setDestination(destination);
    }

    public Message() {
        this.setSource("");
        this.setDestination("");
        this.MESSAGE_ID = messageCounter++;
    }

    public static int getMessageCounter() {
        return messageCounter;
    }
    
    public static void setMessageCounter(int messageCounter) {
        Message.messageCounter = messageCounter;
    }

    public int getMessageID() {
        return MESSAGE_ID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Message{" + "source=" + source + ", destination=" + destination + ", MESSAGE_ID=" + MESSAGE_ID + '}';
    }


}
