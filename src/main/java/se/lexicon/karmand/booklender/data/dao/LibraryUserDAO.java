package se.lexicon.karmand.booklender.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.karmand.booklender.model.entity.LibraryUser;

public interface LibraryUserDAO extends JpaRepository<LibraryUser, String> {
}
