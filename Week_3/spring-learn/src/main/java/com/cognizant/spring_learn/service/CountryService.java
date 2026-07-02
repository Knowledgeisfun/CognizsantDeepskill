package com.cognizant.spring_learn.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cognizant.spring_learn.Country;

@Service
public class CountryService {

    public Country getCountry(String code) {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("US", "United States"));
        countries.add(new Country("DE", "Germany"));
        countries.add(new Country("IN", "India"));
        countries.add(new Country("JP", "Japan"));

        // Using Lambda expression to find the country (Case Insensitive)
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}