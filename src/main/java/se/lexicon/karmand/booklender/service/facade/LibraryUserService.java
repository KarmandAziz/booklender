package se.lexicon.karmand.booklender.service.facade;

import se.lexicon.karmand.booklender.model.dto.BooksDTO;
import se.lexicon.karmand.booklender.model.dto.LibraryUserDto;
import se.lexicon.karmand.booklender.service.GenericEntityService;

import java.util.List;

public interface LibraryUserService extends GenericEntityService<LibraryUserDto, String> {

    LibraryUserDto findById(int userId);
    LibraryUserDto findByEmail(String email);



}
