package com.bnponlinebookstore.springboot.demo.bnponlinestore.entity;

import com.bnponlinebookstore.springboot.demo.bnponlinestore.Repository.BookRepository;
import com.bnponlinebookstore.springboot.demo.bnponlinestore.Repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ShoppingItemRepository shoppingItemRepository;

    @Override
    public void run(String... args) throws Exception {

        if (bookRepository.count() == 0) {
            bookRepository.save(new Book("Effective Java", "Joshua Bloch", 45.99));
            bookRepository.save(new Book("Clean Code", "Robert C. Martin", 39.99));
            bookRepository.save(new Book("Spring in Action", "Craig Walls", 49.99));
            bookRepository.save(new Book("Java Concurrency in Practice", "Brian Goetz", 55.99));
            bookRepository.save(new Book("Design Patterns", "Erich Gamma", 59.99));

            System.out.println("Sample books added to the DB");
        } else {
            System.out.println("Books already exist in DB");
        }

        if (shoppingItemRepository.count() == 0) {
            //fetch books
            Book book1 = bookRepository.findById(1L).orElse(null);
            Book book2 = bookRepository.findById(2L).orElse(null);
            Book book3 = bookRepository.findById(3L).orElse(null);

            if (book1 != null) {
                shoppingItemRepository.save(new ShoppingItem(book1, 2));
            }
            if (book2 != null) {
                shoppingItemRepository.save(new ShoppingItem(book2, 2));
            }
            if (book3 != null) {
                shoppingItemRepository.save(new ShoppingItem(book3, 4));
            }
            System.out.println("shopping items added to DB");

        } else {
            System.out.println("shopping items already exists in DB");
        }
    }
}
