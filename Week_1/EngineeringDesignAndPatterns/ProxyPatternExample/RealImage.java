package ProxyPatternExample;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer(filename); // Expensive operation happens on creation
    }

    private void loadFromRemoteServer(String filename) {
        System.out.println("Downloading " + filename + " from remote server... (This takes time)");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}