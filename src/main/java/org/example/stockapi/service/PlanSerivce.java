package org.example.stockapi.service;

import org.example.stockapi.model.Plan;
import org.example.stockapi.repository.PlanRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanSerivce {

    private final PlanRepository planRepository;

    public PlanSerivce(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public void CreatePlan(Plan plan) {
        planRepository.save(plan);
    }
}
