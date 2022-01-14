package se.lexicon.karmand.booklender.service;

import se.lexicon.karmand.booklender.model.dto.BooksDTO;
import se.lexicon.karmand.booklender.model.dto.LibraryUserDTO;
import se.lexicon.karmand.booklender.model.dto.LoansDTO;
import se.lexicon.karmand.booklender.model.entity.Books;
import se.lexicon.karmand.booklender.model.entity.LibraryUser;
import se.lexicon.karmand.booklender.model.entity.Loans;

public interface DTOService {
    BooksDTO toBooksDTO(Books books);
    LibraryUserDTO toLibraryUserDTO(LibraryUser libraryUser);
    LoansDTO toFullLoansDTO(Loans loans);
    LoansDTO toSmallLoansDTO(Loans loans);
}
