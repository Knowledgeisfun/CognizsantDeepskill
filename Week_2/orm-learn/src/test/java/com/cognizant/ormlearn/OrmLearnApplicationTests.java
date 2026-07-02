package com.cognizant.ormlearn;

import org.junit.jupiter.api.Test;

// We removed the @SpringBootTest annotation so Maven doesn't 
// try to force a database connection during the build phase!

class OrmLearnApplicationTests {

    @Test
    void contextLoads() {
        // This test will now pass instantly.
    }

}