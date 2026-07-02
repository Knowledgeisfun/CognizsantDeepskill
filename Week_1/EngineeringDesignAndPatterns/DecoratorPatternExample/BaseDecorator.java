package DecoratorPatternExample;

public class BaseDecorator implements Notifier {
    protected Notifier message;

    public BaseDecorator(Notifier message){
        this.message = message;
    }

    public String send(){
        return message.send();
    }

}
