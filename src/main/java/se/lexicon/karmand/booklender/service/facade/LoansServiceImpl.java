package se.lexicon.karmand.booklender.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.karmand.booklender.data.dao.LoansDAO;
import se.lexicon.karmand.booklender.model.dto.LoansDTO;
import se.lexicon.karmand.booklender.model.forms.LoansForm;
import se.lexicon.karmand.booklender.service.DTOService;
import se.lexicon.karmand.booklender.service.entity.LoansEntityService;

import java.util.List;
import java.util.stream.Collectors;

public class LoansServiceImpl implements LoansService{

    private LoansEntityService loansEntityService;
    private DTOService dtoService;
    private LoansDAO loansDAO;

    @Autowired
    public LoansServiceImpl(LoansEntityService loansEntityService, DTOService dtoService, LoansDAO loansDAO) {
        this.loansEntityService = loansEntityService;
        this.dtoService = dtoService;
        this.loansDAO = loansDAO;
    }

    @Override
    public LoansDTO create(LoansForm loansForm) {
        return dtoService.toFullLoansDTO(loansEntityService.create(loansForm));
    }

    @Override
    public List<LoansDTO> findAll() {
        return loansEntityService.findAll().stream()
                .map(dtoService::toSmallLoansDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoansDTO update(String id, LoansForm loansForm) {
        return dtoService.toFullLoansDTO(loansEntityService.update(id,loansForm));
    }

    @Override
    public void delete(String id) {
        loansEntityService.delete(id);
    }

    @Override
    public LoansDTO findById(String loanId) {
        return dtoService.toFullLoansDTO(loansEntityService.findById(loanId));
    }

    @Override
    public List<LoansDTO> findByLoanTakerId(String userId) {
        return loansDAO.findByUserId(userId).stream()
                .map(dtoService::toSmallLoansDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoansDTO> findByBookId(String bookId) {
        return loansDAO.findByBooksId(bookId).stream()
                .map(dtoService::toSmallLoansDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoansDTO> findByTerminated(boolean isTerminated) {
        return loansDAO.findByTerminatedStatus(isTerminated).stream()
                .map(dtoService::toSmallLoansDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoansDTO concludeLoan(String id, String userId) {
        return dtoService.toFullLoansDTO(
                loansEntityService.concludeLoan(id, userId)
        );
    }


}
