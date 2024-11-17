package org.example.stockapi.model;

import jakarta.persistence.*;
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
    private AppUser user;
    @OneToMany(mappedBy = "plan")
    private List<PlanStock> stocks;

    public AppUser getOwner() {
        return user;
    }

    public void setOwner(AppUser user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getId() {
        return Id;
    }
}
