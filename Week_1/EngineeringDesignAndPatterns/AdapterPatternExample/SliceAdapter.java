package AdapterPatternExample;

public class SliceAdapter implements PaymentProcessor{
    private SlicePayApi slicepayapi;

    public SliceAdapter(SlicePayApi slicePayApi){
        this.slicepayapi = slicePayApi;
    }

    @Override
    public void processPayment(double amount){
        slicepayapi.executeUPITransaction(amount);
    }


}
