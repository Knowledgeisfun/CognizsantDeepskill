package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
    
    private String code;
    private String name;

    // Empty parameter constructor
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public Country(String code, String name) {
        LOGGER.debug("Inside Parametraized Country Constructor.");
        this.code = code;
        this.name = name;
    }

    // Getters and Setters with logs
    public String getCode() {
        LOGGER.debug("Inside getCode method.");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode method.");
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName method.");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName method.");
        this.name = name;
    }

    // toString method
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}