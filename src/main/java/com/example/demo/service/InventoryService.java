package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Item;

public interface InventoryService {
    Item addItem(Item item);
    List<Item> getAllItem();
    Item getItemById(int id);
    Item updateItem(Item item);
    void deleteItemById(int id);
}
