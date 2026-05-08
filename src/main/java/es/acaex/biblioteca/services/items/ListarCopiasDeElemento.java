package es.acaex.biblioteca.services.items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.models.Copy;
import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class ListarCopiasDeElemento {

    @Autowired
    ItemsRepository itemsRepository;

    public List<Copy> execute(Long itemId) {
        return itemsRepository.findById(itemId).orElseThrow().getCopies();
    }
}
