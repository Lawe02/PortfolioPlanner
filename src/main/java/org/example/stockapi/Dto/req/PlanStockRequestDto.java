package org.example.stockapi.Dto.req;

public record PlanStockRequestDto(String stockSymbol, int priceWhenAdded, double moneyInvested, int monthlyPercentageProgress) {
}
