package se.lexicon.karmand.booklender.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.karmand.booklender.model.entity.Books;

import java.util.List;

public interface BooksDAO extends JpaRepository<Books, String> {

    @Query("SELECT b FROM Books b WHERE b.isAvailable = :isAvailable")
    List<Books> findByAvailableStatus(@Param("isAvailable") boolean isAvailable);

    @Query("SELECT b FROM Books b WHERE b.isReserved = :isReserved")
    List<Books> findByReservedStatus(@Param("isReserved") boolean isReserved);

    @Query("SELECT t FROM Books t WHERE UPPER(t.titles) = UPPER(:titles)")
    List<Books> findByTitle(@Param("titles") String Titles);


}
