package se.lexicon.karmand.booklender.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
@Table(name = "loans")
public class Loans {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false)
    private String id;
    private boolean concluded;
    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_loanTaker")
    private LibraryUser loanTaker;
    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_books")
    private Books books;
    private LocalDate loanDate;

    public Loans(String id, boolean concluded, LibraryUser loanTaker, Books books, LocalDate loanDate) {
        this.id = id;
        this.concluded = concluded;
        this.loanTaker = loanTaker;
        this.books = books;
        this.loanDate = loanDate;
    }

    public Loans() {
    }

    public boolean isOverdue(){
        LocalDate dueDate = loanDate.plusDays(books.getMaxLoanDays());
        boolean isOverdue = LocalDate.now().isAfter(dueDate);
        return isOverdue;
    }

    public BigDecimal getFine(){
        Period p = Period.between(loanDate.plusDays(books.getMaxLoanDays()), LocalDate.now());
        int d = p.getDays();
        BigDecimal fine = BigDecimal.ZERO;
        if(d > 0){
            fine = BigDecimal.valueOf(d * books.getFinePerDay().longValue());
        }
        return fine;
    }

    public boolean extendLoan(){
        if(books.isReserved() || isOverdue()){
            return false;
        }
        this.loanDate = LocalDate.now();
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }

    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        this.loanTaker = loanTaker;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }


    @Override
    public String toString() {
        return "Loans{" +
                "id='" + id + '\'' +
                ", concluded=" + concluded +
                ", loanDate=" + loanDate +
                '}';
    }
}