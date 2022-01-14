package se.lexicon.karmand.booklender.service.entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.karmand.booklender.data.dao.LoansDAO;
import se.lexicon.karmand.booklender.exception.AppResourceNotFoundException;
import se.lexicon.karmand.booklender.model.entity.Loans;
import se.lexicon.karmand.booklender.model.forms.LoansForm;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoansEntityServiceImpl implements LoansEntityService {

    private final LoansDAO loansDAO;
    private final BooksEntityService booksEntityService;
    private final LibraryUserEntityService libraryUserEntityService;

    public LoansEntityServiceImpl(LoansDAO loansDAO, BooksEntityService booksEntityService, LibraryUserEntityService libraryUserEntityService) {
        this.loansDAO = loansDAO;
        this.booksEntityService = booksEntityService;
        this.libraryUserEntityService = libraryUserEntityService;
    }


    @Override
    public Loans create(LoansForm loansForm) {
        if (loansForm == null) throw new IllegalArgumentException("loansForm was null");
        Loans loans = new Loans();
        loans.setLoansId(loansForm.getLoansId());
        loans.setLoanDate(loansForm.getLoanDate());
        loans.setConcluded(loansForm.isConcluded());

        return loansDAO.save(loans);
    }

    @Override
    public Loans findById(String id) {
        return loansDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find loans with id " + id));
    }

    @Override
    public List<Loans> findAll() {
        return loansDAO.findAll();
    }

    @Override
    public Loans update(String id, LoansForm loansForm) {
        Loans loans = findById(id);
        if (!id.equals(loansForm.getLoansId())) {
            throw new IllegalArgumentException("Id didn't match found " + LoansForm.class.getName() + ".id");
        }
        loans.setLoansId(loansForm.getLoansId());
        loans.setLoanDate(loansForm.getLoanDate());
        loans.setConcluded(loansForm.isConcluded());

        return loansDAO.save(loans);
    }

    @Override
    public void delete(String id) {
        Loans loans = findById(id);
        loans.setBooks(null);
        loans.setLoanTaker(null);

        loansDAO.delete(loans);

    }

    @Override
    public Optional<Loans> findByUserId(String userId) {
        return loansDAO.findByUserId(userId);
    }

    @Override
    public Optional<Loans> findByBooksId(String booksId) {
        return loansDAO.findByBooksId(booksId);
    }

    @Override
    public List<Loans> findByTerminatedStatus(boolean concluded) {
        return loansDAO.findByTerminatedStatus(concluded);
    }

    public Loans concludeLoan(String id, String userid) {
        Loans loan = findById(id);
        if (userid.equals(loan.getLoanTaker().getUserId())) {
            loan.setConcluded(true);
            return loansDAO.save(loan);
        } else {
            throw new IllegalArgumentException("userId did not match id of loanTaker");
        }
    }
}
