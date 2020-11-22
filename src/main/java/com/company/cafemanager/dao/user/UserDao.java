package com.company.cafemanager.dao.user;

import com.company.cafemanager.dao.Dao;
import com.company.cafemanager.entity.user.User;

import java.util.Optional;
import java.util.UUID;

/**
 * Dao interface for "User" objects
 * @param <T> Type of Entity
 */
public interface UserDao<T extends User> extends Dao<T, UUID> {
    Optional<T> getByUsername(final String username);

    Optional<T> getByEmail(final String email);
}
