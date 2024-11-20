package org.example.stockapi.controller;

import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.example.stockapi.Dto.req.CreatePlanRequestDto;
import org.example.stockapi.Dto.resp.PlanResponseDto;
import org.example.stockapi.Dto.resp.StockPlanResponseDto;
import org.example.stockapi.Dto.resp.StockResponseDto;
import org.example.stockapi.Dto.resp.UserPlansResponseDto;
import org.example.stockapi.model.Plan;
import org.example.stockapi.model.Stock;
import org.example.stockapi.service.PlanSerivce;
import org.example.stockapi.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/plans/{planId}")
    public ResponseEntity<PlanResponseDto> getPlan(@PathVariable String planId, @RequestParam String userName) {
        Plan plan = planSerivce.getPlan(planId, userName);
        List<StockPlanResponseDto> stockPlanResponseDto = plan.getStocks()
                .stream()
                .map(stock -> new StockPlanResponseDto(
                        stock.getStock().getName(),
                        stock.getStock().getSymbol(),
                        stock.getMonthlyPercentageDevelopment(),
                        stock.getPriceWhenAdded(),
                        stock.getMoneyInvested()
                )).toList();
        PlanResponseDto result = new PlanResponseDto(plan.getName(), plan.getDescription(), stockPlanResponseDto);
        return ResponseEntity.ok(result);
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

    @GetMapping("/search")
    public ResponseEntity<List<StockResponseDto>> getAllStocksByName(@RequestParam String name, @RequestParam int page)  {
        try {
            List<Stock> stocks = stockService.getStocks(page,name);
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

    @GetMapping("/plans")
    public ResponseEntity<UserPlansResponseDto> getPlansForUser(@RequestParam String userName) {
        // Fetch plans for the given user from the service
        List<Plan> plans = planSerivce.getPlansForUser(userName);

        // Map the fetched plans to PlanResponseDto objects
        List<PlanResponseDto> listResponseDto = plans.stream()
                .map(plan -> new PlanResponseDto(
                        plan.getName(),
                        plan.getDescription(),
                        plan.getStocks().stream()
                                .map(stock -> new StockPlanResponseDto(
                                        stock.getStock().getSymbol(),
                                        stock.getStock().getName(),
                                        stock.getMonthlyPercentageDevelopment(),
                                        stock.getPriceWhenAdded(),
                                        stock.getMoneyInvested()
                                ))
                                .toList()
                ))
                .toList();

        // Wrap the list of PlanResponseDto objects in a UserPlansResponseDto
        UserPlansResponseDto responseDto = new UserPlansResponseDto(listResponseDto);

        // Return the response
        return ResponseEntity.ok(responseDto);
    }


}
