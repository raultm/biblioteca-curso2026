package es.acaex.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.acaex.biblioteca.models.Copy;

@Repository
public interface CopiesRepository extends JpaRepository<Copy, Long> {

}