package org.example.stockapi.Dto.resp;

import java.util.List;

public record PlanResponseDto(String id,String name, String description, List<StockPlanResponseDto> stockPlans) {
}