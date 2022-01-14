package se.lexicon.karmand.booklender.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.karmand.booklender.model.dto.BooksDTO;
import se.lexicon.karmand.booklender.model.dto.LibraryUserDto;
import se.lexicon.karmand.booklender.model.dto.LoansDTO;
import se.lexicon.karmand.booklender.model.entity.Books;
import se.lexicon.karmand.booklender.model.entity.LibraryUser;
import se.lexicon.karmand.booklender.model.entity.Loans;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class EntityToDTOConverter implements DTOService{


    @Override
    public BooksDTO toBooksDTO(Books books) {
       if(books == null) return null;
       BooksDTO booksDTO = new BooksDTO();
       booksDTO.setTitle(books.getTitles());
       booksDTO.setBookId(books.getBooksId());
       booksDTO.setAvailable(books.isAvailable());
       booksDTO.setReserved(books.isReserved());
       booksDTO.setMaxLoanDays(books.getMaxLoanDays());
       booksDTO.setFinePerDay(books.getFinePerDay());
       return booksDTO;
    }


    @Override
    public LibraryUserDto toLibraryUserDTO(LibraryUser libraryUser) {
        if(libraryUser == null) return null;
        LibraryUserDto libraryUserDto = new LibraryUserDto();
        libraryUserDto.setUserId(libraryUser.getUserId());
        libraryUserDto.setEmail(libraryUser.getEmail());
        libraryUserDto.setName(libraryUser.getName());
        libraryUserDto.setRegDate(libraryUserDto.getRegDate());
        return libraryUserDto;
    }



    @Override
    public LoansDTO toFullLoansDTO(Loans loans) {
        if(loans == null) return null;
        LoansDTO loansDTO = toSmallLoansDTO(loans);
        loansDTO.setLoanTaker(toLibraryUserDTO(loans.getLoanTaker()));
        loansDTO.setBooks(toBooksDTO(loans.getBooks()));
        return loansDTO;
    }

    @Override
    public LoansDTO toSmallLoansDTO(Loans loans) {
        if(loans == null) return null;
        LoansDTO loansDTO = new LoansDTO();
        loansDTO.setLoanId(loans.getLoansId());
        loansDTO.setLoanDate(loans.getLoanDate());
        loansDTO.setConcluded(loans.isConcluded());
        loansDTO.setLoanTaker(toLibraryUserDTO(loans.getLoanTaker()));
        loansDTO.setBooks(toBooksDTO(loans.getBooks()));
        return loansDTO;
    }
}
