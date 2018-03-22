package pl.net.malinowski.stock.stockservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.net.malinowski.stock.stockservice.model.Quote;
import pl.net.malinowski.stock.stockservice.service.StockService;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final RestTemplate restTemplate;
    private final StockService stockService;

    @Autowired
    public StockController(RestTemplate restTemplate, StockService stockService) {
        this.restTemplate = restTemplate;
        this.stockService = stockService;
    }

    @GetMapping("/{username}")
    public List<Quote> getStock(@PathVariable String username) {
        ResponseEntity<List<String>> entity = restTemplate.exchange("http://db-service/api/quote/" + username, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<String>>() {
                });
        return stockService.findStocks(entity.getBody());
    }
}
