package org.example.stockapi.model;

import jakarta.persistence.*;

@Entity
public class PlanStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int priceWhenAdded;
    private double moneyInvested;
    private int quantity;

    @ManyToOne
    private Plan plan;
    @OneToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id") // Foreign key to Stock
    private Stock stock;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
