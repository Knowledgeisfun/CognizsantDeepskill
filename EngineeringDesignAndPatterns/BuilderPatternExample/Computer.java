package BuilderPatternExample;

public class Computer {
    String cpu;
    int ram;
    int storage;

    private Computer(Builder builder){
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public static class Builder{
        String cpu;
        int ram;
        int storage;

        public Builder(String cpu){
            this.cpu = cpu;
        }
        public Builder setRam(int ram){
            this.ram = ram;
            return this;
        }
        public Builder setStorage(int storage){
            this.storage = storage;
            return this;
        }
        public Computer build(){
            return new Computer(this);
        }
    }
}
