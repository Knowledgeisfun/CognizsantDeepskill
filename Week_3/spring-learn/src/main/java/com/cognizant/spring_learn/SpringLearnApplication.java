package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Inside main - Spring Web Application Started!");
        
        // Invoke the display method
        displayCountry();
    }

    public static void displayCountry() {
        LOGGER.info("Start displayCountry");
        
        // 1. Read the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // 2. Retrieve the bean
        Country country = context.getBean("country", Country.class);
        
        // 3. Display it
        LOGGER.debug("Country : {}", country.toString());
        
        LOGGER.info("End displayCountry");
    }
}