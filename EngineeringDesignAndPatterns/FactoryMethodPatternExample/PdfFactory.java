package FactoryMethodPatternExample;

public class PdfFactory extends Factory {
    @Override
    public Document createDocument(){
        return new PdfDocument();
    }
}
