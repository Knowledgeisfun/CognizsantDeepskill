package com.cognizant.spring_learn.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.spring_learn.Country;

@RestController
public class CountryController {

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        // Load the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Fetch the bean defined in country.xml
        Country country = (Country) context.getBean("country", Country.class);
        
        return country;
    }
}