package com.showroom;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import java.io.IOException;

public class TestUtil {
    public static <T> T retrieveResourceFromResponse(CloseableHttpResponse response, Class<T> clazz) 
      throws IOException, org.apache.hc.core5.http.ParseException {
     
        // 1. Extract the raw JSON string from the network response body
        String jsonFromResponse = EntityUtils.toString(response.getEntity());
        
        // 2. Configure Jackson to ignore extra JSON fields we don't care about
        ObjectMapper mapper = new ObjectMapper()
          .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
          
        // 3. Map the JSON string into your Java Object (e.g., Car.class)
        return mapper.readValue(jsonFromResponse, clazz);
    }
}