package org.example.stockapi.service;

import org.example.stockapi.model.AppUser;
import org.example.stockapi.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser getAppUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public void CreateAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }
}
