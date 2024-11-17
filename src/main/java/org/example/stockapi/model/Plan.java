package org.example.stockapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    @ManyToOne
    @NotNull
    private AppUser user;

    public List<PlanStock> getStocks() {
        return stocks;
    }

    public void setStocks(List<PlanStock> stocks) {
        this.stocks = stocks;
    }

    @OneToMany(mappedBy = "plan")
    private List<PlanStock> stocks;

    public AppUser getOwner() {
        return user;
    }

    public void setOwner(AppUser user) {
        this.user = user;
    }

    public Long getId() {
        return Id;
    }
}
