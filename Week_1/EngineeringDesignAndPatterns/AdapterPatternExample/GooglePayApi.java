package AdapterPatternExample;
//3d party 
public class GooglePayApi {

    public void executeUPITransaction(double amountInRupees) {
        System.out.println("Processing UPI payment of ₹" + amountInRupees + " via GooglePay gateway.");
    }
}
