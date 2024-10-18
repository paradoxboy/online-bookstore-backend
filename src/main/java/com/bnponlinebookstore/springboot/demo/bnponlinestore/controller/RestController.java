package com.bnponlinebookstore.springboot.demo.bnponlinestore.controller;

import com.bnponlinebookstore.springboot.demo.bnponlinestore.entity.Book;
import com.bnponlinebookstore.springboot.demo.bnponlinestore.entity.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/books")
public class RestController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById (@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            return ResponseEntity.ok(bookService.updateBook(book));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
