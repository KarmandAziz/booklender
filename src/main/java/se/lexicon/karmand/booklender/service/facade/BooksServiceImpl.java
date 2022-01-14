package se.lexicon.karmand.booklender.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.karmand.booklender.data.dao.BooksDAO;
import se.lexicon.karmand.booklender.model.dto.BooksDTO;
import se.lexicon.karmand.booklender.model.forms.BooksForm;
import se.lexicon.karmand.booklender.service.DTOService;

import java.util.List;
@Service
@Transactional
public class BooksServiceImpl implements BooksService{

    private BooksDAO booksDAO;
    private DTOService dtoService;

    @Autowired
    public BooksServiceImpl(BooksDAO booksDAO, DTOService dtoService) {
        this.booksDAO = booksDAO;
        this.dtoService = dtoService;
    }

    @Override
    public BooksDTO create(BooksForm booksForm) {
        return null;
    }

    @Override
    public List<BooksDTO> findAll() {
        return null;
    }

    @Override
    public BooksDTO update(String id, BooksForm booksForm) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public BooksDTO findById(String bookId) {
        return null;
    }

    @Override
    public List<BooksDTO> findByTitle(String title) {
        return null;
    }

    @Override
    public List<BooksDTO> findByAvailable(boolean available) {
        return null;
    }

    @Override
    public List<BooksDTO> findByReserved(boolean reserved) {
        return null;
    }
}
