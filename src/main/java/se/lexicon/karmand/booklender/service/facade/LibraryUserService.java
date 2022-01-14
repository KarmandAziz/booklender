package se.lexicon.karmand.booklender.service.facade;

import se.lexicon.karmand.booklender.model.dto.LibraryUserDTO;
import se.lexicon.karmand.booklender.model.forms.LibraryUserForm;
import se.lexicon.karmand.booklender.service.GenericEntityService;

import java.util.List;

public interface LibraryUserService extends GenericEntityService<LibraryUserDTO, LibraryUserForm> {

    LibraryUserDTO findById(String userId);
    List<LibraryUserDTO> findByEmail(String email);



}
