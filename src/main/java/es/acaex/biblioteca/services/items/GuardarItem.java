package es.acaex.biblioteca.services.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.models.Item;
import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class GuardarItem {

    @Autowired
    ItemsRepository itemsRepository;

    public Item execute(Item item) {
        return itemsRepository.save(item);
    }
}
