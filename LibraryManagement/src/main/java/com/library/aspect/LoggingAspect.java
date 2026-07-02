package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
    // 1. We use SLF4J here to perform the actual logging
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // 2. This method is the "Advice"
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // Record the start time
        long start = System.currentTimeMillis();

        // 3. This executes the original method (e.g., processNewBook())
        Object proceed = joinPoint.proceed();

        // Calculate how long it took
        long executionTime = System.currentTimeMillis() - start;

        // 4. Log the result using SLF4J
        logger.info("Method [" + joinPoint.getSignature() + "] executed in " + executionTime + "ms");
        
        return proceed;
    }
}