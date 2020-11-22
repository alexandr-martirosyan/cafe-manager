package com.company.cafemanager.dao;

import com.company.cafemanager.entity.user.User;

import java.util.Optional;
import java.util.UUID;

/**
 * Dao interface for "User" objects
 * @param <T> Type of Entity
 */
public interface UserDao<T extends User> extends Dao<T, UUID> {
    Optional<T> getByUsername(String username);

    Optional<T> getByEmail(String email);
}
