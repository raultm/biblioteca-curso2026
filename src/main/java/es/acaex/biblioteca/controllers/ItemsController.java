package es.acaex.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.models.Item;
import es.acaex.biblioteca.repositories.ItemsRepository;

@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    ItemsRepository repository;

    @PostMapping
    public Item save(@RequestBody Item item) {
        return repository.save(item);
    }

    @GetMapping
    public List<Item> get() {
        return repository.findAll();
    }

    @GetMapping("{itemId}")
    public Item findBy(@PathVariable("itemId") Long itemId) {
        return repository.findById(itemId).orElseThrow();
    }
}
