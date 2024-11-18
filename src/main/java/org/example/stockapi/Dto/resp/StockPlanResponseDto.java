package org.example.stockapi.Dto.resp;

public record StockPlanResponseDto(String name, String symbol, int monthlyPercentageDevelopment, int priceWhenAdded, double moneyInvested) {
}
