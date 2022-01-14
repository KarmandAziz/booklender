package se.lexicon.karmand.booklender.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

import static se.lexicon.karmand.booklender.constants.EntityConstants.GENERATOR;
import static se.lexicon.karmand.booklender.constants.EntityConstants.UUID_GENERATOR;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String booksId;
    private String titles;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;
    private boolean isAvailable;
    private boolean isReserved;

    public Books() {
    }

    public Books(String booksId, String titles, int maxLoanDays, BigDecimal finePerDay, String description, boolean isAvailable, boolean isReserved) {
        this.booksId = booksId;
        this.titles = titles;
        this.maxLoanDays = maxLoanDays;
        this.finePerDay = finePerDay;
        this.description = description;
        this.isAvailable = isAvailable;
        this.isReserved = isReserved;
    }

    @Override
    public String toString() {
        return "Books{" +
                "titles='" + titles + '\'' +
                ", maxLoanDays=" + maxLoanDays +
                ", finePerDay=" + finePerDay +
                ", description='" + description + '\'' +
                ", isAvailable=" + isAvailable +
                ", isReserved=" + isReserved +
                '}';
    }

    public String getBooksId() {
        return booksId;
    }

    public void setBooksId(String id) {
        this.booksId = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    public BigDecimal getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(BigDecimal finePerDay) {
        this.finePerDay = finePerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
