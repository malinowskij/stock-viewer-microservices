package pl.net.malinowski.stock.dbservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.net.malinowski.stock.dbservice.model.Quote;
import pl.net.malinowski.stock.dbservice.repositories.QuotesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuotesServiceImpl implements QuotesService {

    private final QuotesRepository quotesRepository;

    @Autowired
    public QuotesServiceImpl(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @Override
    public List<String> findByUsername(String username) {
        return quotesRepository.findByUsername(username)
                .stream().map(Quote::getQuote).collect(Collectors.toList());
    }

    @Override
    public Quote save(Quote quote) {
        return quotesRepository.save(quote);
    }
}
