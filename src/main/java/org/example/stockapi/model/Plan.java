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

    private String name;
    private String description;

    @ManyToOne
    @NotNull
    private AppUser user;
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
