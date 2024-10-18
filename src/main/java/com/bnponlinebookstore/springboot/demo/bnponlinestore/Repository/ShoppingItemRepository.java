package com.bnponlinebookstore.springboot.demo.bnponlinestore.Repository;

import com.bnponlinebookstore.springboot.demo.bnponlinestore.entity.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {

}