package se.lexicon.karmand.booklender.service.facade;

import se.lexicon.karmand.booklender.model.dto.LoansDTO;
import se.lexicon.karmand.booklender.model.forms.LoansForm;
import se.lexicon.karmand.booklender.service.GenericEntityService;

import java.util.List;

public interface LoansService extends GenericEntityService<LoansDTO, LoansForm> {

    LoansDTO findById(String loanId);
    List<LoansDTO> findByLoanTakerId(String userId);
    List<LoansDTO> findByBookId(String bookId);
    List<LoansDTO> findByTerminated(boolean isTerminated);


}
