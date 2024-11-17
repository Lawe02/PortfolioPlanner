package org.example.stockapi.repository;

import org.example.stockapi.model.Plan;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends ListCrudRepository<Plan, Long> {
}
