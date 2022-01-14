package se.lexicon.karmand.booklender.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookDAO extends JpaRepository<Book, String> {
}
