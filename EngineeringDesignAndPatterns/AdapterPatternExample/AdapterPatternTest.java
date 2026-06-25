package AdapterPatternExample;

public class AdapterPatternTest {
   public static void main(String[] args){

    SlicePayApi mySliceAcc = new SlicePayApi();
    GooglePayApi myGoogleAcc = new GooglePayApi();

    PaymentProcessor sliceupiProcessor = new SliceAdapter(mySliceAcc);
    PaymentProcessor googlepayupiProcessor = new GooglePayAdapter(myGoogleAcc);    

    System.out.println("--- Initiating Payments ---");
    sliceupiProcessor.processPayment(1500.50);
    googlepayupiProcessor.processPayment(25.00);

   }
}
