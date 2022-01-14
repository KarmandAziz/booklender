package se.lexicon.karmand.booklender.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.karmand.booklender.data.dao.LibraryUserDAO;
import se.lexicon.karmand.booklender.exception.AppResourceNotFoundException;
import se.lexicon.karmand.booklender.model.entity.LibraryUser;
import se.lexicon.karmand.booklender.model.forms.BooksForm;
import se.lexicon.karmand.booklender.model.forms.LibraryUserForm;

import java.util.List;
import java.util.Optional;

public class LibraryUserEntityServiceImpl implements LibraryUserEntityService {

    private LibraryUserDAO libraryUserDAO;

    @Autowired
    public LibraryUserEntityServiceImpl(LibraryUserDAO libraryUserDAO) {
        this.libraryUserDAO = libraryUserDAO;
    }

    @Override
    public LibraryUser create(LibraryUserForm libraryUserForm) {
        if(libraryUserForm == null) throw new IllegalArgumentException("Dto was null");
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setUserId(libraryUserForm.getUserId());
        libraryUser.setEmail(libraryUserForm.getEmail());
        libraryUser.setName(libraryUserForm.getName());
        libraryUser.setRegDate(libraryUserForm.getRegDate());

        return libraryUserDAO.save(libraryUser);
    }

    @Override
    public LibraryUser findById(String id) {
        return libraryUserDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("LibraryUser id " + id + " could not be found"));
    }

    @Override
    public List<LibraryUser> findAll() {
        return libraryUserDAO.findAll();
    }

    @Override
    public LibraryUser update(String id, LibraryUserForm libraryUserForm) {
        LibraryUser libraryUser = findById(id);
        if(!libraryUser.getUserId().equals(libraryUserForm.getUserId())) {
            throw new IllegalArgumentException("Parameter id didn't match "+ LibraryUserForm.class.getName() + ".id");}

        libraryUser.setUserId(libraryUserForm.getUserId());
        libraryUser.setRegDate(libraryUserForm.getRegDate());
        libraryUser.setName(libraryUserForm.getName());
        libraryUser.setEmail(libraryUserForm.getEmail());

        return libraryUserDAO.save(libraryUser);
    }

    @Override
    public void delete(String id) {
        libraryUserDAO.deleteById(id);

    }

    @Override
    public Optional<LibraryUser> findByEmail(String email) {
        return findByEmail(email);
    }
}
