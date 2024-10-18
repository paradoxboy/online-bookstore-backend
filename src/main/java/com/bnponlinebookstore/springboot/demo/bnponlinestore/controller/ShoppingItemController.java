package com.bnponlinebookstore.springboot.demo.bnponlinestore.controller;

import com.bnponlinebookstore.springboot.demo.bnponlinestore.Repository.*;
import com.bnponlinebookstore.springboot.demo.bnponlinestore.entity.Book;
import com.bnponlinebookstore.springboot.demo.bnponlinestore.entity.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingItemController {

    @Autowired
    private ShoppingItemRepository shoppingItemRepository;

    @Autowired
    private BookRepository bookRepository;

    //Retrieve all items
    @GetMapping
    public List<ShoppingItem> getShoppingItems() {
        return shoppingItemRepository.findAll();

    }

    //Add book to shopping list
    @PostMapping
    public ResponseEntity<String> addToShopping (@RequestParam Long bookId, @RequestParam int quantity) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            ShoppingItem shoppingItem = new ShoppingItem(book.get(), quantity);
            shoppingItemRepository.save(shoppingItem);
            return ResponseEntity.ok("Book added!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }

    //Update quantity of a shopping item
    @PutMapping("/{itemId}")
    public ResponseEntity<String> updateShoppingItem(@PathVariable Long itemId, @RequestParam int quantity) {
        Optional<ShoppingItem> shoppingItem  = shoppingItemRepository.findById(itemId);
        if (shoppingItem.isPresent()) {
            ShoppingItem shoppingItem1 = shoppingItem.get();
            shoppingItem1.setQuantity(quantity);
            shoppingItemRepository.save(shoppingItem1);
            return ResponseEntity.ok("Shopping item updated");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shopping item not found");
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> removeShoppingItem(@PathVariable Long itemId) {
        Optional<ShoppingItem> shoppingItem  = shoppingItemRepository.findById(itemId);
        if (shoppingItem.isPresent()) {
            shoppingItemRepository.deleteById(itemId);
            return ResponseEntity.ok("Shopping item deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shopping item not found");
        }
    }

}
