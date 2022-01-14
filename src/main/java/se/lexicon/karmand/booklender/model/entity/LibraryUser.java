package se.lexicon.karmand.booklender.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

import static se.lexicon.karmand.booklender.constants.EntityConstants.GENERATOR;
import static se.lexicon.karmand.booklender.constants.EntityConstants.UUID_GENERATOR;

@Entity
@Table(name = "libraryUser")
public class LibraryUser {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    private String userId;
    private LocalDate regDate;
    private String name;
    @Column(unique = true)
    private String email;

    public LibraryUser() {
    }

    public LibraryUser(String id, LocalDate regDate, String name, String email) {
        this.userId = id;
        this.regDate = regDate;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
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

    @Override
    public String toString() {
        return "LibraryUser{" +
                "id='" + userId + '\'' +
                ", regDate=" + regDate +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
