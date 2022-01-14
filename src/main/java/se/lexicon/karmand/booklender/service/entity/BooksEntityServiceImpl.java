package se.lexicon.karmand.booklender.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.karmand.booklender.data.dao.BooksDAO;
import se.lexicon.karmand.booklender.exception.AppResourceNotFoundException;
import se.lexicon.karmand.booklender.model.entity.Books;
import se.lexicon.karmand.booklender.model.forms.BooksForm;

import java.util.List;

public class BooksEntityServiceImpl implements BooksEntityService{

    private final BooksDAO booksDAO;


    @Autowired
    public BooksEntityServiceImpl(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @Override
    public Books create(BooksForm form) {
        if(form == null) throw new IllegalArgumentException("BooksForm was null!");
        Books books = new Books();
        books.setBooksId(form.getBooksId());
        books.setAvailable(form.isAvailable());
        books.setDescription(form.getDescription());
        books.setReserved(form.isReserved());
        books.setFinePerDay(form.getFinePerDay());
        books.setMaxLoanDays(form.getMaxLoanDays());
        return booksDAO.save(books);
    }

    @Override
    public Books findById(String id) {
        return booksDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Book with id "+ id + " could not be found"));
    }

    @Override
    public List<Books> findAll() {
        return booksDAO.findAll();
    }

    @Override
    public Books update(String id, BooksForm form) {
        Books books = findById(id);
        if(!books.getBooksId().equals(form.getBooksId())){
            throw new IllegalArgumentException("Parameter id didn't match "+ BooksForm.class.getName() + ".id");
        }
        books.setBooksId(form.getBooksId());
        books.setReserved(form.isReserved());
        books.setAvailable(form.isAvailable());
        books.setDescription(form.getDescription());
        books.setMaxLoanDays(form.getMaxLoanDays());
        books.setFinePerDay(form.getFinePerDay());
        books.setTitles(form.getTitles());

        return booksDAO.save(books);
    }

    @Override
    public void delete(String id) {
        booksDAO.deleteById(id);
    }

    @Override
    public List<Books> findByAvailableStatus(boolean isAvailable) {
        return booksDAO.findByAvailableStatus(isAvailable);
    }

    @Override
    public List<Books> findByReservedStatus(boolean isReserved) {
        return booksDAO.findByReservedStatus(isReserved);
    }

    @Override
    public List<Books> findByTitle(String titles) {
        return findByTitle(titles);
    }
}
