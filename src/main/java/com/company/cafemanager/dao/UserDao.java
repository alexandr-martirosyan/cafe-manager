package com.company.cafemanager.dao;

import com.company.cafemanager.entity.user.User;

import java.util.UUID;

public interface UserDao<T extends User> extends Dao<T, UUID> {
    T getByUsername(String username);

    T getByEmail(String email);
}
