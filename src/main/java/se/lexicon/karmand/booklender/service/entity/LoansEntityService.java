package se.lexicon.karmand.booklender.service.entity;

import se.lexicon.karmand.booklender.model.entity.Loans;
import se.lexicon.karmand.booklender.model.forms.LoansForm;
import se.lexicon.karmand.booklender.service.GenericEntityService;

import java.util.List;
import java.util.Optional;

public interface LoansEntityService extends GenericEntityService<Loans, LoansForm> {

    Optional<Loans> findByUserId(String userId);
    Optional<Loans> findByBooksId(String booksId);
    List<Loans> findByTerminatedStatus(boolean concluded);
    Loans concludeLoan(String id, String userid);


}
