package pl.net.malinowski.stock.dbservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.net.malinowski.stock.dbservice.model.Quote;

import java.util.List;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, Long> {
    List<Quote> findByUsername(String username);
}
