package org.example.stockapi.repository;

import org.example.stockapi.model.AppUser;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<AppUser, Long> {
}
