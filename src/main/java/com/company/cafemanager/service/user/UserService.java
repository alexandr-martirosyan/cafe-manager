package com.company.cafemanager.service.user;

import com.company.cafemanager.entity.user.User;
import com.company.cafemanager.service.CafeService;

import java.util.Optional;
import java.util.UUID;

/**
 * Service interface for "User" objects
 * @param <T> Type of entity
 */
public interface UserService<T extends User> extends CafeService<T, UUID> {
    T getByUsername(final String username);

    T getByEmail(final String email);
}
