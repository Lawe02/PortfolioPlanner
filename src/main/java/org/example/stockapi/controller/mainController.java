package org.example.stockapi.controller;

import org.example.stockapi.Dto.resp.StockResponseDto;
import org.example.stockapi.model.Stock;
import org.example.stockapi.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class mainController {

    private final StockService stockService;

    public mainController(StockService stockService) {
        this.stockService = stockService;
    }
    @GetMapping
    public ResponseEntity<List<StockResponseDto>> getAllStocks()  {
        try {
            List<Stock> stocks = stockService.getStocks();
            List<StockResponseDto> stockResponseDtos = stocks
                    .stream()
                    .map(stock -> new StockResponseDto(stock.getSymbol(), stock.getName()))
                    .toList();

            return ResponseEntity.ok(stockResponseDtos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
