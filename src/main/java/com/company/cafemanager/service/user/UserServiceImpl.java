package com.company.cafemanager.service.user;

import com.company.cafemanager.dao.user.UserDao;
import com.company.cafemanager.entity.user.User;
import com.company.cafemanager.service.CafeServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public abstract class UserServiceImpl<T extends User> extends CafeServiceImpl<T, UUID> implements UserService<T> {
    private final UserDao<T> userDao;

    public UserServiceImpl(final UserDao<T> userDao, final Class<T> clazz) {
        super(userDao, clazz);
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public T getByUsername(final String username) {
        return checkOptionalValue(userDao.getByUsername(username), "username").get();
    }

    @Override
    @Transactional
    public T getByEmail(final String email) {
        return checkOptionalValue(userDao.getByEmail(email), "email").get();
    }
}
