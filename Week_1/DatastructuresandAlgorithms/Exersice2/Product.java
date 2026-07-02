package DatastructuresandAlgorithms.Exersice2;

public class Product implements Comparable<Product> {
    int productID;
    String productName;
    String category;

    Product(int id, String name, String category ){
        productID = id;
        productName = name;
        this.category = category;
    }

    @Override
    public int compareTo(Product otherProduct){
        return Integer.compare(this.productID, otherProduct.productID);
    }

    @Override
    public String toString(){
    return "ID: " + productID + " | Name: " + productName + " | Category: " + category;    }
}
