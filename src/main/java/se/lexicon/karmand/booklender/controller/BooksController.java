package se.lexicon.karmand.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.karmand.booklender.model.dto.BooksDTO;
import se.lexicon.karmand.booklender.model.entity.Books;
import se.lexicon.karmand.booklender.model.forms.BooksForm;
import se.lexicon.karmand.booklender.service.facade.BooksService;

import java.util.List;

@RestController
public class BooksController {

    private final BooksService booksService;

   @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/api/v1/books/{id}")
    public ResponseEntity<BooksDTO> findById(@PathVariable("id") String id){
       return ResponseEntity.ok(booksService.findById(id));
    }

    @GetMapping("/api/v1/books/find_all")
    public ResponseEntity <List<BooksDTO>> findAll(){
       return ResponseEntity.ok().body(booksService.findAll());
    }

    @GetMapping("/api/v1/books/find_titles")
    public ResponseEntity<List<BooksDTO>> findByTitle(@PathVariable("title") String title){
       return ResponseEntity.ok(booksService.findByTitle(title));
    }

    @PostMapping("/api/v1/books")
    public ResponseEntity<BooksDTO> create(@RequestBody BooksForm booksForm){
       return ResponseEntity.status(201).body(booksService.create(booksForm));
    }
    @DeleteMapping("/api/v1/books/{id}")
    public ResponseEntity<Void> Delete(@PathVariable("id") String id){
       booksService.delete(id);
       return ResponseEntity.noContent().build();
    }
}
