package com.inventory.Test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.Test.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
