package SingletonPatternExample;

public class LoggerTest {
    public static void main(String[] args) {
        System.out.println("Starting Application...");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if(logger1 == logger2){
            System.out.println("Sucess: 2 logger point to the exact same instance");
        }
        else{
            System.out.println("Failed: Instance are difference");

        }

        logger1.log("This message was sent using logger1 reference.");
        logger2.log("This message was sent using logger2 reference.");
    }   
}