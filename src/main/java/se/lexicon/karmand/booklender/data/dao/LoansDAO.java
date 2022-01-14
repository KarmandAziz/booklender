package se.lexicon.karmand.booklender.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.karmand.booklender.model.entity.Books;
import se.lexicon.karmand.booklender.model.entity.Loans;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface LoansDAO extends JpaRepository<Loans, String> {

    @Query("SELECT i FROM Loans i WHERE i.loansId = :loansId")
    Optional<Loans> findByLoansId(@Param("loansId") String loansId);

    @Query("SELECT i FROM Loans i WHERE i.books.booksId =:booksId")
    Optional<Loans> findByBooksId(@Param("booksId") String booksId);

    @Query("SELECT c FROM Loans c WHERE c.concluded =:concluded")
    List<Loans> findByTerminatedStatus(@Param("concluded") boolean concluded);


}
