package org.example.stockapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class AppUser {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String firstName;
    private String lastName;
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Plan> plans;

    public List<Plan> getPlans() {
        return plans;
    }

    public Plan getPlanById(Long id) {
        for (Plan plan : plans) {
            if (plan.getId().equals(id)) {
                return plan;
            }
        }
        return null;
    }

    public void removePlan(Long id) {
        this.plans.remove(getPlanById(id));
    }

    public AppUser() {}

    public AppUser(String userName) {
        this.username = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }
}
