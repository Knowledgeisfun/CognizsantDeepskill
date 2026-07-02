package FactoryMethodPatternExample;

public class Main{
    public static void main(String[] args){

        Factory wordfactory = new WordFactory();
        Document one = wordfactory.createDocument();
        one.getType();

        Factory pdffactory = new PdfFactory();
        Document two = pdffactory.createDocument();
        two.getType();

        Factory excelfactory = new ExcelFactory();
        Document three = excelfactory.createDocument();
        three.getType();
    }
}
