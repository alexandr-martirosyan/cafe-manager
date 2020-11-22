package com.company.cafemanager.service.user;

import com.company.cafemanager.dao.user.UserDao;
import com.company.cafemanager.entity.user.User;
import com.company.cafemanager.service.CafeServiceImpl;
import com.company.cafemanager.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl<T extends User> extends CafeServiceImpl<T, UUID> implements UserService<T> {
    private UserDao<T> userDao;

    @Autowired
    public UserServiceImpl(UserDao<T> userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public Optional<T> getByUsername(String username) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<T> getByEmail(String email) {
        return Optional.empty();
    }
}
