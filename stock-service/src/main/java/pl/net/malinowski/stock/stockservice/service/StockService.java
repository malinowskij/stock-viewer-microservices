package pl.net.malinowski.stock.stockservice.service;

import pl.net.malinowski.stock.stockservice.model.Quote;

import java.util.List;

public interface StockService {
    List<Quote> findStocks(List<String> quotes);
}
