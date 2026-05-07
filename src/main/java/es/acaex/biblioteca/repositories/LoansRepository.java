package es.acaex.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.acaex.biblioteca.models.Loan;

@Repository
public interface LoansRepository extends JpaRepository<Loan, Long> {

}
