package com.inventory.Test.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Item{
    

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int boh;
    private float price;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateAdded;
   
    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getBoh() {
        return boh;
    }
    public void setBoh(int boh) {
        this.boh = boh;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public LocalDateTime getDateAdded() {
        return dateAdded;
    }
    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

  

}
