package org.example.stockapi.model;

import jakarta.persistence.*;

@Entity
public class PlanStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int monthlyPercentageDevelopment;
    private int priceWhenAdded;
    private double moneyInvested;

    public int getPriceWhenAdded() {
        return priceWhenAdded;
    }

    public void setPriceWhenAdded(int priceWhenAdded) {
        this.priceWhenAdded = priceWhenAdded;
    }

    public int getMonthlyPercentageDevelopment() {
        return monthlyPercentageDevelopment;
    }

    public void setMonthlyPercentageDevelopment(int monthlyPercentageDevelopment) {
        this.monthlyPercentageDevelopment = monthlyPercentageDevelopment;
    }

    public double getMoneyInvested() {
        return moneyInvested;
    }

    public void setMoneyInvested(double moneyInvested) {
        this.moneyInvested = moneyInvested;
    }

    @ManyToOne
    private Plan plan;

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @OneToOne
    @JoinColumn(name = "symbol", referencedColumnName = "id") // Foreign key to Stock
    private Stock stock;

}
