package DecoratorPatternExample;

public class NotifierDecorator extends BaseDecorator{
      public NotifierDecorator(Notifier message){
        super(message);
    }
    public String send(){
        return "hi/ " + super.send() + " /hi";
    } 
}
