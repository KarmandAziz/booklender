package se.lexicon.karmand.booklender.model.forms;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.annotation.Validated;
import se.lexicon.karmand.booklender.model.entity.Books;
import se.lexicon.karmand.booklender.model.entity.LibraryUser;
import se.lexicon.karmand.booklender.validation.OnPost;
import se.lexicon.karmand.booklender.validation.OnPut;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

import static se.lexicon.karmand.booklender.constants.EntityConstants.DATETIME_IN_PAST;

@Validated
public class LoansForm implements Serializable {

    @NotBlank(groups = OnPut.class)
    private String loansId;
    private boolean concluded;
    @FutureOrPresent(message = DATETIME_IN_PAST, groups = {OnPost.class, OnPut.class})
    private LocalDate loanDate;

    public LoansForm() {
    }

    public String getLoansId() {
        return loansId;
    }

    public void setLoansId(String loansId) {
        this.loansId = loansId;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }


}
