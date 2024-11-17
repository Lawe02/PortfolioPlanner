package org.example.stockapi.service;

import org.example.stockapi.Dto.req.CreatePlanRequestDto;
import org.example.stockapi.model.AppUser;
import org.example.stockapi.model.Plan;
import org.example.stockapi.repository.AppUserRepository;
import org.example.stockapi.repository.PlanRepository;
import org.example.stockapi.repository.StockRepository;
import org.springframework.stereotype.Service;

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


    }
}
