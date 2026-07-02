package DecoratorPatternExample;

public class DecoratorPatternTest {
    public static void main(String[] args){
        String alert = "CPU is running high";

        Notifier emailNotifier = new EmailNotifier(alert);

        Notifier smsNotification = new SMSNotifierDecorator(emailNotifier);
        System.out.println(smsNotification.send());
    }
}
