package FactoryMethodPatternExample;

public class ExcelFactory extends Factory {
    @Override
    public Document createDocument(){
        return new ExcelDocument();
    }
}
