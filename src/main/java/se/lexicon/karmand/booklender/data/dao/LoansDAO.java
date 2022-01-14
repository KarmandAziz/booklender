package se.lexicon.karmand.booklender.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.karmand.booklender.model.entity.Books;
import se.lexicon.karmand.booklender.model.entity.Loans;

import java.util.List;
import java.util.Optional;

public interface LoansDAO extends JpaRepository<Loans, String> {

    @Query("SELECT i FROM Loans i WHERE Loans.id = :id")
    List<Loans> findByLoansId(@Param("id") String id);

    @Query("SELECT i FROM Books i WHERE Books.id =:id")
    List<Books> findByBooksId(@Param("id") String id);

    @Query("SELECT c FROM Loans c WHERE c.concluded =:concluded")
    List<Loans> findByTerminatedStatus(@Param("concluded") boolean concluded);


}
