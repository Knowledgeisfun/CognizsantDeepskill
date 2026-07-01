package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    //Knife
    private BookRepository bookRepository;

    // The setter method Spring will use to inject the dependency (Handing over the Knife)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // The business logic
    public void processNewBook() {
        System.out.println("Service: Processing new library book...");
        bookRepository.saveBook(); // Uses the injected repository!
    }
}