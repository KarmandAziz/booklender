package se.lexicon.karmand.booklender.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.karmand.booklender.model.entity.Loans;

public interface LoansDAO extends JpaRepository<Loans, String> {
}
