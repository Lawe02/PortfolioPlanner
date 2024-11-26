package org.example.stockapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class AppUser {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Email;
    private String firstName;
    private String lastName;
    private String username;

    @OneToMany(mappedBy = "user")
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

    public Long getId() {
        return id;
    }
}
