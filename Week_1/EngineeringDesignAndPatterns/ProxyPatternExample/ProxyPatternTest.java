package ProxyPatternExample;

public class ProxyPatternTest {
    public static void main(String[] args){
        Image firstimage = new ProxyImage("img1");
        firstimage.display();
    }
}
