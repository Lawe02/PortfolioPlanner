package org.example.stockapi.service;

import org.example.stockapi.model.Stock;
import org.example.stockapi.repository.StockRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }



    public void feedActiveStocksToDb(String exchange) throws Exception {
        List<Stock> stocks = new ArrayList<>();
        String requestUri = "https://www.alphavantage.co/query?function=LISTING_STATUS&apikey=M78CIK0T40MEZHNZ";

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUri))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) { // HTTP OK
            String body = response.body();
            String[] lines = body.split("\n");

            for (int i = 1; i < lines.length; i++) {
                String line = lines[i];

                if (isStockInExchange(line, exchange)) {
                    Stock stock = parseLineToStock(line);
                    if (stock != null) {
                        stocks.add(stock);
                    }
                }
            }
        }
        stockRepository.saveAll(stocks);
    }

    private boolean isStockInExchange(String line, String exchange) {
        String[] fields = line.split(",", -1);

        String recordExchange = fields[2];
        String recordAssetType = fields[3];

        return recordExchange.contains(exchange) && recordAssetType.equalsIgnoreCase("Stock");
    }

    private Stock parseLineToStock(String line) {
        try {
            String[] fields = line.split(",", -1);

            Stock stock = new Stock();
            stock.setSymbol(fields[0]);
            stock.setName(fields[1]);
            stock.setExchange(fields[2]);

            return stock;
        } catch (Exception e) {
            System.err.println("Error parsing line: " + line);
            e.printStackTrace();
            return null;
        }
    }
}
