package se.lexicon.karmand.booklender.model.forms;

import org.springframework.validation.annotation.Validated;
import se.lexicon.karmand.booklender.validation.OnPost;
import se.lexicon.karmand.booklender.validation.OnPut;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

import static se.lexicon.karmand.booklender.constants.EntityConstants.MANDATORY_FIELD;

@Validated
public class LibraryUserForm implements Serializable {

    @NotBlank(message = MANDATORY_FIELD, groups = OnPut.class)
    private String userId;
    private LocalDate regDate;
    @NotBlank(message = MANDATORY_FIELD, groups = {OnPost.class, OnPut.class})
    private String name;
    @Column(unique = true)
    @NotBlank(message = MANDATORY_FIELD, groups = {OnPost.class, OnPut.class})
    private String email;

    public LibraryUserForm() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
