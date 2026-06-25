package DecoratorPatternExample;

//concrete componenet
public class EmailNotifier implements Notifier {
    private String content;

    public EmailNotifier(String content){
        this.content = content;
    }

    @Override
    public String send(){
        return content;
    }
}
