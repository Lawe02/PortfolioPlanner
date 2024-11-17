package org.example.stockapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Stock {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identifier;
    private String name;
    private int currentPrice;
    private int PreviousClosingPrice;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
