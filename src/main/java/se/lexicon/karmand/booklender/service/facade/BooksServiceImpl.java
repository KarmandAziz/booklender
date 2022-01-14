package se.lexicon.karmand.booklender.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.karmand.booklender.data.dao.BooksDAO;
import se.lexicon.karmand.booklender.model.dto.BooksDTO;
import se.lexicon.karmand.booklender.model.forms.BooksForm;
import se.lexicon.karmand.booklender.service.DTOService;
import se.lexicon.karmand.booklender.service.entity.BooksEntityService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BooksServiceImpl implements BooksService{

    private BooksEntityService booksEntityService;
    private DTOService dtoService;

    @Autowired
    public BooksServiceImpl(BooksEntityService booksEntityService, DTOService dtoService) {
        this.booksEntityService = booksEntityService;
        this.dtoService = dtoService;
    }


    @Override
    public BooksDTO create(BooksForm booksForm) {
        return dtoService.toBooksDTO(booksEntityService.create(booksForm));
    }

    @Override
    public List<BooksDTO> findAll() {
        return booksEntityService.findAll().stream()
                .map(dtoService::toBooksDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BooksDTO update(String id, BooksForm booksForm) {
        return dtoService.toBooksDTO(booksEntityService.update(id, booksForm));
    }

    @Override
    public void delete(String id) {
        booksEntityService.delete(id);

    }

    @Override
    public BooksDTO findById(String bookId) {
        return dtoService.toBooksDTO(booksEntityService.findById(bookId));
    }

    @Override
    public List<BooksDTO> findByTitle(String title) {
        return booksEntityService.findByTitle(title).stream()
                .map(dtoService::toBooksDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BooksDTO> findByAvailable(boolean available) {
        return booksEntityService.findByAvailableStatus(available).stream()
                .map(dtoService::toBooksDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BooksDTO> findByReserved(boolean reserved) {
        return booksEntityService.findByReservedStatus(reserved)
                .stream().map(dtoService::toBooksDTO)
                .collect(Collectors.toList());
    }
}
