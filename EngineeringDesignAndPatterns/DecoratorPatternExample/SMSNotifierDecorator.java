package DecoratorPatternExample;

public class SMSNotifierDecorator extends BaseDecorator {
    public SMSNotifierDecorator(Notifier message){
        super(message);
    }
    public String send(){
        return "sms/ " + super.send() + " /sms";
    }
}
