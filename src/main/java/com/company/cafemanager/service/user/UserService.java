package com.company.cafemanager.service;

import com.company.cafemanager.entity.user.User;

import java.util.Optional;
import java.util.UUID;

/**
 * Service interface for "User" objects
 * @param <T> Type of entity
 */
public interface UserService<T extends User> extends CafeService<T, UUID> {
    Optional<T> getByUsername(String username);

    Optional<T> getByEmail(String email);
}
