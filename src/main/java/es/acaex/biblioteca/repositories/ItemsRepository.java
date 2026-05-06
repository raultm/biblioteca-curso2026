package es.acaex.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.acaex.biblioteca.models.Item;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {

}
