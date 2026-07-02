package AdapterPatternExample;

public class GooglePayAdapter implements PaymentProcessor {

    private GooglePayApi googlepayapi;

    GooglePayAdapter(GooglePayApi googlepayapi){
        this.googlepayapi = googlepayapi;
    }

    @Override
    public void processPayment(double amount){
        googlepayapi.executeUPITransaction(amount);
    }

   
}
