package pl.net.malinowski.stock.dbservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.net.malinowski.stock.dbservice.model.Quote;
import pl.net.malinowski.stock.dbservice.model.Quotes;
import pl.net.malinowski.stock.dbservice.service.QuotesService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class QuotesController {

    private final QuotesService quotesService;

    @Autowired
    public QuotesController(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping("/quote/{username}")
    public List<String> getQuotes(@PathVariable String username) {
        return quotesService.findByUsername(username);
    }

    @PostMapping("/quote/add")
    public List<String> addQuote(@RequestBody Quotes quotes) {
        quotes.getQuotes()
                .stream().map(quote -> new Quote(quotes.getUsername(), quote))
                .forEach(quotesService::save);
        return getQuotes(quotes.getUsername());
    }
}
