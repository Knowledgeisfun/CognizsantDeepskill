package com.example; // Make sure it says exactly this
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
