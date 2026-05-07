package es.acaex.biblioteca.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.models.Copy;
import es.acaex.biblioteca.models.Item;
import es.acaex.biblioteca.repositories.CopiesRepository;
import es.acaex.biblioteca.repositories.ItemsRepository;

@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    CopiesRepository copiesRepository;

    @PostMapping
    public Item save(@RequestBody Item item) {
        return itemsRepository.save(item);
    }

    @GetMapping
    public List<Item> get() {
        return itemsRepository.findAll();
    }

    @GetMapping("{itemId}")
    public Item findBy(@PathVariable("itemId") Long itemId) {
        return itemsRepository.findById(itemId).orElseThrow();
    }

    @PostMapping("{itemId}/copies")
    public Copy crearCopia(@PathVariable("itemId") Long itemId) {
        return copiesRepository.save(Copy.builder()
                .item(itemsRepository.findById(itemId).orElseThrow())
                .acquiredAt(new Date())
                .reservedBy("")
                .build());
    }

    @GetMapping("{itemId}/copies")
    public List<Copy> listarCopias(@PathVariable("itemId") Long itemId) {
        return itemsRepository.findById(itemId).orElseThrow().getCopies();
    }
}
