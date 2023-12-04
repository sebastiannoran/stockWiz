package com.inventory.Test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.Test.model.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
    
}
