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

    @ManyToOne
    private Plan plan;
    @OneToOne
    @JoinColumn(name = "symbol", referencedColumnName = "id") // Foreign key to Stock
    private Stock stock;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
