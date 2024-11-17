package org.example.stockapi.service;

import org.example.stockapi.Dto.req.CreatePlanRequestDto;
import org.example.stockapi.model.AppUser;
import org.example.stockapi.model.Plan;
import org.example.stockapi.model.PlanStock;
import org.example.stockapi.model.Stock;
import org.example.stockapi.repository.AppUserRepository;
import org.example.stockapi.repository.PlanRepository;
import org.example.stockapi.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanSerivce {

    private final PlanRepository planRepository;
    private final AppUserRepository appUserRepository;
    private final StockRepository stockRepository;

    public PlanSerivce(PlanRepository planRepository, AppUserRepository appUserRepository, StockRepository stockRepository) {
        this.planRepository = planRepository;
        this.appUserRepository = appUserRepository;
        this.stockRepository = stockRepository;
    }

    public void CreatePlan(CreatePlanRequestDto createPlanRequestDto) {
        AppUser user = appUserRepository.findByUsername(createPlanRequestDto.userName());

        Plan plan = new Plan();
        plan.setName(createPlanRequestDto.name());
        plan.setDescription(createPlanRequestDto.description());
        plan.setOwner(user);

        List<PlanStock> planStocks = createPlanRequestDto.stockPlans().stream()
                .map(stockPlanDto -> {
                    Stock stock = stockRepository.findBySymbol(stockPlanDto.stockSymbol());

                    PlanStock planStock = new PlanStock();
                    planStock.setStock(stock);
                    planStock.setMoneyInvested(stockPlanDto.moneyInvested());
                    planStock.setMonthlyPercentageDevelopment(stockPlanDto.monthlyPercentageProgress());
                    planStock.setPriceWhenAdded(stockPlanDto.priceWhenAdded());

                    return planStock;
                })
                .toList();

        plan.setStocks(planStocks);
        planRepository.save(plan);
    }
}
