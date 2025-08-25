package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(int id) {
        Optional<Item> opt = itemRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItemById(int id) {
        itemRepository.deleteById(id);
    }
}
