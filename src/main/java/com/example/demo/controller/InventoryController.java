package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Item;
import com.example.demo.service.InventoryService;

@RestController
@RequestMapping("/inventoryapi/")
@CrossOrigin(origins = "*")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    
    @GetMapping("/")
    public String home() {
        return "Jenkins Full Stack Deployment Demo";
    }

    // Create
    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item savedItem = inventoryService.addItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // Read all
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = inventoryService.getAllItem();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Read by id
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getItemById(@PathVariable int id) {
        Item item = inventoryService.getItemById(id);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Item with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/update")
    public ResponseEntity<?> updateItem(@RequestBody Item item) {
        Item existing = inventoryService.getItemById(item.getId());
        if (existing != null) {
            Item updatedItem = inventoryService.updateItem(item);
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot update. Item with ID " + item.getId() + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable int id) {
        Item existing = inventoryService.getItemById(id);
        if (existing != null) {
            inventoryService.deleteItemById(id);
            return new ResponseEntity<>("Item with ID " + id + " deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot delete. Item with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
