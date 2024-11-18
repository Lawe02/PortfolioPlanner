package org.example.stockapi.Dto.resp;

import java.util.List;

public record PlanResponseDto(String name, String description, List<StockPlanResponseDto> stockPlans) {
}