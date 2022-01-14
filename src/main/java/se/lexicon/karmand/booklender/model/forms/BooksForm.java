package se.lexicon.karmand.booklender.model.forms;

import org.springframework.validation.annotation.Validated;
import se.lexicon.karmand.booklender.validation.OnPost;
import se.lexicon.karmand.booklender.validation.OnPut;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

import static se.lexicon.karmand.booklender.constants.EntityConstants.MANDATORY_FIELD;

@Validated
public class BooksForm implements Serializable {

    @NotBlank(message = MANDATORY_FIELD, groups = OnPut.class)
    private String booksId;
    @NotBlank(message = MANDATORY_FIELD, groups = {OnPut.class, OnPost.class})
    private String titles;
    @NotNull(message = MANDATORY_FIELD, groups = {OnPut.class, OnPost.class})
    private int maxLoanDays;
    @NotNull(message = MANDATORY_FIELD, groups = {OnPut.class, OnPost.class})
    private BigDecimal finePerDay;
    @NotBlank(message = MANDATORY_FIELD, groups = {OnPut.class, OnPost.class})
    private String description;
    private boolean isAvailable;
    private boolean isReserved;

    public BooksForm() {
    }

    public String getBooksId() {
        return booksId;
    }

    public void setBooksId(String booksId) {
        this.booksId = booksId;
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

