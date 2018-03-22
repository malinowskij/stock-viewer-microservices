package pl.net.malinowski.stock.stockservice.service;

import org.springframework.stereotype.Service;
import pl.net.malinowski.stock.stockservice.model.Quote;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    @Override
    public List<Quote> findStocks(List<String> quotes) {
        return quotes.stream().map(q -> {
            Stock stock = extractStock(q);
            if (stock != null)
                return new Quote(q, stock.getQuote().getPrice());
            return new Quote(q, new BigDecimal(-1.0));
        }).collect(Collectors.toList());
    }

    private Stock extractStock(String quote) {
        Stock stock = null;
        try {
            stock = YahooFinance.get(quote);
        } catch (IOException ignored) {}
        return stock;
    }
}
