package se.lexicon.karmand.booklender.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class ApplicationMaintenance {

    private LibraryUser createUser(String id, LocalDate regDate, String name, String email){
        return new LibraryUser(id,regDate,name, email);
    }


}
