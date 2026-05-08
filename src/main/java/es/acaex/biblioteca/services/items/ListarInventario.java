package es.acaex.biblioteca.services.items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.models.Item;
import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class ListarInventario {

    @Autowired
    ItemsRepository itemsRepository;

    public List<Item> execute() {

        Sort sort = Sort.by(
                Sort.Order.asc("title").ignoreCase(),
                Sort.Order.desc("type").ignoreCase());

        return itemsRepository.findAll(sort);
        // return itemsRepository.findAllByOrderByTitleAsc();
    }
}
