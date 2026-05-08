package es.acaex.biblioteca.services.items;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.models.Copy;
import es.acaex.biblioteca.repositories.CopiesRepository;
import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class CrearCopiaEnElemento {

    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    CopiesRepository copiesRepository;

    public Copy execute(Long itemId) {
        return copiesRepository.save(Copy.builder()
                .item(itemsRepository.findById(itemId).orElseThrow())
                .acquiredAt(new Date())
                .reservedBy("")
                .build());
    }
}
