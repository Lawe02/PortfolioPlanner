package org.example.stockapi.repository;

import org.example.stockapi.model.AppUser;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends ListCrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
