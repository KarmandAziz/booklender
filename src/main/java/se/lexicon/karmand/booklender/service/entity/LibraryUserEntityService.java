package se.lexicon.karmand.booklender.service.entity;

import org.springframework.data.repository.query.Param;
import se.lexicon.karmand.booklender.model.entity.LibraryUser;
import se.lexicon.karmand.booklender.model.forms.LibraryUserForm;
import se.lexicon.karmand.booklender.service.GenericEntityService;

import java.util.Optional;

public interface LibraryUserEntityService extends GenericEntityService<LibraryUser, LibraryUserForm> {


    Optional<LibraryUser> findByEmail(String email);

}
