package se.lexicon.karmand.booklender.validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.karmand.booklender.data.dao.LibraryUserDAO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final LibraryUserDAO libraryUserDAO;

    @Autowired
    public UniqueEmailValidator(LibraryUserDAO libraryUserDAO) {
        this.libraryUserDAO = libraryUserDAO;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }
        return !libraryUserDAO.findByEmail(value.trim()).isPresent();
    }
}
