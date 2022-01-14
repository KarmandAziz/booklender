package se.lexicon.karmand.booklender.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import se.lexicon.karmand.booklender.model.entity.Books;

import java.io.Serializable;
import java.time.LocalDate;

public class LoansDTO implements Serializable {

    private String loanId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LibraryUserDto loanTaker;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BooksDTO books;
    private LocalDate loanDate;
    private boolean concluded;

    public LoansDTO() {
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public LibraryUserDto getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUserDto loanTaker) {
        this.loanTaker = loanTaker;
    }

    public BooksDTO getBooks() {
        return books;
    }

    public void setBooks(BooksDTO books) {
        this.books = books;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }
}
