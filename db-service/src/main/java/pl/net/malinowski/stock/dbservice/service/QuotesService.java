package pl.net.malinowski.stock.dbservice.service;

import org.springframework.stereotype.Service;
import pl.net.malinowski.stock.dbservice.model.Quote;

import java.util.List;

public interface QuotesService {
    List<String> findByUsername(String username);
    Quote save(Quote quote);
}
