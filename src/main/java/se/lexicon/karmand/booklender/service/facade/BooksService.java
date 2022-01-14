package se.lexicon.karmand.booklender.service.facade;

import se.lexicon.karmand.booklender.model.dto.BooksDTO;
import se.lexicon.karmand.booklender.service.GenericEntityService;

import java.util.List;

public interface BooksService {

    BooksDTO findById(String bookId);
    List<BooksDTO> findByTitle(String title);
    List<BooksDTO> findByAvailable(boolean available);
    List<BooksDTO> findByReserved(boolean reserved);
}
