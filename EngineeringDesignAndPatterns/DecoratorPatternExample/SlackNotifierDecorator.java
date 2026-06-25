package DecoratorPatternExample;

public class SlackNotifierDecorator extends BaseDecorator {
   public SlackNotifierDecorator(Notifier message){
        super(message);
    }
    public String send(){
        return "slack/ " + super.send() + " /slack";
    } 
}
