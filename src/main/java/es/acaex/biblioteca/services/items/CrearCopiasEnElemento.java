package es.acaex.biblioteca.services.items;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.models.Copy;
import es.acaex.biblioteca.repositories.CopiesRepository;
import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class CrearCopiasEnElemento {

    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    CopiesRepository copiesRepository;

    public List<Copy> execute(Long itemId, int cantidad) {
        List<Copy> copias = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            copias.add(crearCopia(itemId));
        }

        return copias;
    }

    private Copy crearCopia(Long itemId) {
        return copiesRepository.save(Copy.builder()
                .item(itemsRepository.findById(itemId).orElseThrow())
                .acquiredAt(new Date())
                .reservedBy("")
                .build());
    }
}
