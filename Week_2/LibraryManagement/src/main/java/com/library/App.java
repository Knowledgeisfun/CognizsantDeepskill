package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Spring Container is starting ---");

        // 1. Load the ApplicationContext (The Kitchen Manager)
        // It reads the blueprint (applicationContext.xml) and creates all the beans
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Ask the context for the BookService bean (Retrieving the 'prepped' chef)
        // Notice we don't use 'new BookService()'!
        BookService bookService = (BookService) context.getBean("bookService");

        // 3. Test the configuration
        // If everything is wired correctly, the service will use the injected repository
        bookService.processNewBook();

        System.out.println("--- Application finished successfully ---");
    }
}