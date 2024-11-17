package org.example.stockapi.repository;

import org.example.stockapi.model.AppUser;
import org.springframework.data.repository.ListCrudRepository;

public interface AppUserRepository extends ListCrudRepository<AppUser, Long> {
}
