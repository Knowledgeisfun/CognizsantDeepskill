package AdapterPatternExample;
//3rd party
public class SlicePayApi{
    public void executeUPITransaction(double amountInRupees) {
        System.out.println("Processing UPI payment of ₹" + amountInRupees + " via Slice gateway.");
    }
}
