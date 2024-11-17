package org.example.stockapi.Dto.req;

import java.util.List;

public record CreatePlanRequestDto(String name, String description, String userName, List<PlanStockRequestDto> stockPlans) {
}
