package main.java.com.example;



// 1. The external dependency (usually an interface)
public interface ExternalApi {
    String getData();
}

// 2. The class you are actually testing
class MyService {
    private ExternalApi api;

    // Dependency Injection via constructor
    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}