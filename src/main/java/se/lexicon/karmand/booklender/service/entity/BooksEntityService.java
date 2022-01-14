package se.lexicon.karmand.booklender.service.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.karmand.booklender.model.entity.Books;
import se.lexicon.karmand.booklender.model.forms.BooksForm;
import se.lexicon.karmand.booklender.service.GenericEntityService;

import java.util.List;

public interface BooksEntityService extends GenericEntityService<Books, BooksForm> {

    List<Books> findByAvailableStatus(boolean isAvailable);
    List<Books> findByReservedStatus( boolean isReserved);
    List<Books> findByTitle(String Titles);


}
