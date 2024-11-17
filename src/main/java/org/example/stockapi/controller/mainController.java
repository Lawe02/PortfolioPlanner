package org.example.stockapi.controller;

import org.example.stockapi.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class mainController {

    private final StockService stockService;

    public mainController(StockService stockService) {
        this.stockService = stockService;
    }

//    @GetMapping
//    public String index() throws Exception {
//        stockService.feedActiveStocksToDb("NAS");
//        return "§";
//    }

}
