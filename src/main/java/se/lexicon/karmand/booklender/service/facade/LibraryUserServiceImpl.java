package se.lexicon.karmand.booklender.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.karmand.booklender.exception.AppResourceNotFoundException;
import se.lexicon.karmand.booklender.model.dto.LibraryUserDTO;
import se.lexicon.karmand.booklender.model.forms.LibraryUserForm;
import se.lexicon.karmand.booklender.service.DTOService;
import se.lexicon.karmand.booklender.service.entity.LibraryUserEntityService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LibraryUserServiceImpl implements LibraryUserService{

    private final LibraryUserEntityService libraryUserEntityService;
    private final DTOService dtoService;

    @Autowired
    public LibraryUserServiceImpl(LibraryUserEntityService libraryUserEntityService, DTOService dtoService) {
        this.libraryUserEntityService = libraryUserEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public LibraryUserDTO create(LibraryUserForm libraryUserForm) {
        return dtoService.toLibraryUserDTO(libraryUserEntityService.create(libraryUserForm));
    }


    @Override
    public List<LibraryUserDTO> findAll() {
        return libraryUserEntityService.findAll().stream()
                .map(dtoService::toLibraryUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryUserDTO update(String id, LibraryUserForm libraryUserForm) {
        return dtoService.toLibraryUserDTO(libraryUserEntityService.update(id, libraryUserForm));
    }

    @Override
    public void delete(String id) {
        libraryUserEntityService.delete(id);

    }

    @Override
    public LibraryUserDTO findById(String userId) {
        return dtoService.toLibraryUserDTO(libraryUserEntityService.findById(userId));
    }

    @Override
    public List<LibraryUserDTO> findByEmail(String email) {
        return libraryUserEntityService.findByEmail(email).stream()
                .map(dtoService::toLibraryUserDTO)
                .collect(Collectors.toList());
    }
}
