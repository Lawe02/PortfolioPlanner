package org.example.stockapi.controller;

import jakarta.validation.Valid;
import org.example.stockapi.Dto.req.CreatePlanRequestDto;
import org.example.stockapi.Dto.resp.StockResponseDto;
import org.example.stockapi.model.Plan;
import org.example.stockapi.model.Stock;
import org.example.stockapi.service.PlanSerivce;
import org.example.stockapi.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class mainController {

    private final StockService stockService;
    private final PlanSerivce planSerivce;

    public mainController(StockService stockService, PlanSerivce planSerivce) {
        this.stockService = stockService;
        this.planSerivce = planSerivce;
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

    @PostMapping
    public ResponseEntity<String> createPlan(@RequestBody @Valid CreatePlanRequestDto createPlanRequestDto) {
        planSerivce.CreatePlan(createPlanRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("createdPlan");
    }

}
