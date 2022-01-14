package se.lexicon.karmand.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.karmand.booklender.model.dto.LibraryUserDTO;
import se.lexicon.karmand.booklender.model.forms.LibraryUserForm;
import se.lexicon.karmand.booklender.service.DTOService;
import se.lexicon.karmand.booklender.service.facade.LibraryUserService;
import se.lexicon.karmand.booklender.validation.OnPut;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LibraryUserController {

    private final LibraryUserService libraryUserService;

    @Autowired
    public LibraryUserController(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }

    @GetMapping("/api/v1/user/{id}")
    public ResponseEntity<LibraryUserDTO> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(libraryUserService.findById(id));
    }

    @GetMapping("/api/v1/library_users/search_email")
    public ResponseEntity <List<LibraryUserDTO>> findByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(libraryUserService.findByEmail(email));
    }

    @GetMapping("/api/v1/library_users/find_all")
    public ResponseEntity<List<LibraryUserDTO>> findAll() {
        return ResponseEntity.ok().body(libraryUserService.findAll());
    }

    @PostMapping("/api/v1/users")
    public ResponseEntity<LibraryUserDTO> create(@RequestBody LibraryUserForm form){
        return ResponseEntity.status(201).body(libraryUserService.create(form));
    }

    @DeleteMapping("/api/v1/users/{id}")
    public ResponseEntity<Void> Delete(@PathVariable("id") String id){
        libraryUserService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/api/v1/users/{id}")
    public ResponseEntity<LibraryUserDTO> update(@PathVariable("id") String id, @Validated(OnPut.class) @RequestBody LibraryUserForm libraryUserForm){
        return ResponseEntity.ok(libraryUserService.update(id, libraryUserForm));
    }


}
