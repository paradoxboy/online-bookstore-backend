package com.bnponlinebookstore.springboot.demo.bnponlinestore.Repository;

import com.bnponlinebookstore.springboot.demo.bnponlinestore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
