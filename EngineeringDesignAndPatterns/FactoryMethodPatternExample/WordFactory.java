package FactoryMethodPatternExample;

public class WordFactory extends Factory {

    @Override
    public Document createDocument(){
        return new WordDocument();
    }
}
