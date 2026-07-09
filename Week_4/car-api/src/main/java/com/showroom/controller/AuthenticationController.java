package com.showroom.controller;

import com.showroom.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    public static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    
    public final JwtUtil jwt;
    
    public AuthenticationController(JwtUtil jwt){
        this.jwt = jwt;
    }


    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader){
        logger.info("START: authentication method execution method started");
        logger.debug("Authorization Header received: {}", authHeader);


        // For now, we will generate a token for a hardcoded "admin" user 
        // to prove the generation works!
        String realJwtToken = jwt.generateToken("admin");


        Map<String, String> response = new HashMap<>();
        response.put("token", realJwtToken); // Replace the empty string!

        logger.info("END: authenticate method execution finished.");

        return response;

    }
}
