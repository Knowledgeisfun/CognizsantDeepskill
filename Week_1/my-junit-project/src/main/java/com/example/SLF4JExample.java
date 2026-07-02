package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JExample {
    private static final Logger logger = LoggerFactory.getLogger("Sample Logger");

    public static void main(String[] args) {

        logger.error("This is an error message"); 
        logger.warn("This is a warning message"); 

    }
}
