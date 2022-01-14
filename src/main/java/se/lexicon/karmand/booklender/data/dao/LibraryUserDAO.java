package se.lexicon.karmand.booklender.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.karmand.booklender.model.entity.LibraryUser;

import java.util.List;
import java.util.Optional;

public interface LibraryUserDAO extends JpaRepository<LibraryUser, String> {

    @Query("SELECT e FROM LibraryUser e WHERE UPPER(e.email) = UPPER(:email)")
    Optional<LibraryUser> findByEmail(@Param("email") String email);
}
