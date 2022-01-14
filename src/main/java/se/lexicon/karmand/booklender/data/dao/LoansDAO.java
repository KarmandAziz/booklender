package se.lexicon.karmand.booklender.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.karmand.booklender.model.entity.Loans;

import java.util.List;
import java.util.Optional;

public interface LoansDAO extends JpaRepository<Loans, String> {

    @Query("SELECT i FROM Loans i WHERE i.loanTaker.userId = :userId")
    Optional<Loans> findByUserId(@Param("userId") String userId);

    @Query("SELECT i FROM Loans i WHERE i.books.booksId =:booksId")
    Optional<Loans> findByBooksId(@Param("booksId") String booksId);

    @Query("SELECT c FROM Loans c WHERE c.concluded =:concluded")
    List<Loans> findByTerminatedStatus(@Param("concluded") boolean concluded);


}
