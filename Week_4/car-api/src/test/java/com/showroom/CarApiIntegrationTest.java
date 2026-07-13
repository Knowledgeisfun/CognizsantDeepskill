package com.showroom;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.showroom.model.Car;
import com.showroom.repository.CarRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

// 1. Starts a real local server on a live, random port (e.g., 54321)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarApiIntegrationTest {
    
    // 2. Spring automatically injects the active port number here
    @LocalServerPort
    private int port;

    @Autowired
    private CarRepository carRepository;
    
    private Car savedTestCar;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/api/cars";
    }

    @Test
    public void givenCarDoesNotExist_whenCarInfoIsRetrieved_then404IsReceived() throws Exception {
        // Given
        HttpUriRequest request = new HttpGet(getBaseUrl() + "/999");

        // When (Sending an actual network request over localhost)
        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)) {

            // Then
            assertThat(response.getCode(), equalTo(404)); // SC_NOT_FOUND
        }
    }

    // === TUTORIAL SECTION 4: TESTING THE MEDIA TYPE ===
    @Test
    public void givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson() throws Exception {
        // Given
        String jsonMimeType = "application/json";
        // ✅ THE FIX:
            HttpUriRequest request = new HttpGet(getBaseUrl() + "/" + savedTestCar.getId());

        // When
        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)) {

            // Then
            String mimeType = ContentType.parse(response.getEntity().getContentType()).getMimeType();
            assertEquals(jsonMimeType, mimeType);
        }
    }

    // 2. This runs right BEFORE your test starts. It sets up the exact reality your test expects.
    @BeforeEach
    public void setupDatabase() {
        // Wipe the slate clean so old tests don't mess this one up
        carRepository.deleteAll();

        // Use your exact constructor to create the car
        Car myTestCar = new Car("Toyota", "Camry", "sedan", 25000.0);
        
        // Save it to the DB, and let Hibernate generate the ID. Store it in 'savedTestCar'
        savedTestCar = carRepository.save(myTestCar);
    }

    // === TUTORIAL SECTION 5: TESTING THE JSON PAYLOAD ===
    @Test
    public void givenCarExists_whenCarInformationIsRetrieved_thenRetrievedResourceIsCorrect() throws Exception {
        
        // 3. Instead of guessing "/1", we dynamically use the exact ID we just saved!
        String targetUrl = getBaseUrl() + "/" + savedTestCar.getId();
        HttpUriRequest request = new HttpGet(targetUrl);

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)) {

            // 4. Translate the JSON payload back into your Java object
            Car cleanCarData = TestUtil.retrieveResourceFromResponse(response, Car.class);
            
            // 5. Test the payload data! We KNOW this will pass because we just put it in the DB.
            assertThat(cleanCarData.getBrand(), equalTo("Toyota"));
            assertThat(cleanCarData.getModelName(), equalTo("Camry"));
            assertThat(cleanCarData.getSegment(), equalTo("sedan"));
            
            // We can even test if the API returned the exact same ID that the database generated
            assertThat(cleanCarData.getId(), equalTo(savedTestCar.getId()));
        }
    }
}
