package com.inventory.Test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import com.inventory.Test.model.Item;
import com.inventory.Test.repository.ItemRepository;
import com.inventory.Test.exception.ItemNotFoundException;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ItemController {
    
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/item")
    Item newItem(@RequestBody Item newItem){   
        newItem.setDateAdded(LocalDateTime.now());
        return itemRepository.save(newItem);   

    }

    @GetMapping("/Stock")
    List<Item> getAllItems(){
        return itemRepository.findAll();
    }


@GetMapping("/item/{id}")
Item getItemById(@PathVariable Long id){
    return itemRepository.findById(id)
    .orElseThrow(()->new ItemNotFoundException(id));
}

@PutMapping("/item/{id}")
 Item updateItem(@PathVariable Long id,@RequestParam String name, @RequestParam int boh, @RequestParam float price) {
    return itemRepository.findById(id).map(item->{
        item.setName(name);
        item.setBoh(boh);
        item.setPrice(price);
        return itemRepository.save(item);
    }).orElseThrow(()->new ItemNotFoundException(id));
    
}


@DeleteMapping("/item/{id}")
String deleteItem(@PathVariable Long id){
    if(!itemRepository.existsById(id)){
        throw new ItemNotFoundException(id);
    }
    itemRepository.deleteById(id);
    return "Item with ID"+id+"has been deleted";
}

}
