package com.bnponlinebookstore.springboot.demo.bnponlinestore.entity;

import jakarta.persistence.*;

@Entity
@Table(name="shopping_items")
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column
    private int quantity;

    //define Constructors
    public ShoppingItem() {

    }

    public ShoppingItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    //define Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
