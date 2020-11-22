package com.company.cafemanager.dao;

import com.company.cafemanager.entity.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserDaoImpl<T extends User> extends DaoImpl<T, UUID> implements UserDao<T> {

    @Autowired
    public UserDaoImpl(final EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public Optional<T> getByUsername(String username) {
        return getBy("username", username);
    }

    @Override
    public Optional<T> getByEmail(String email) {
        return getBy("email", email);
    }

    private Optional<T> getBy(String type, String value) {
        // get the current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        // get the className of object
        String className = clazz.getSimpleName();
        // constructing hql string for executing
        String hql = String.format("from %s where %s.%s = :%s", className, className, type, value);
        Query<T> query = session.createQuery(hql);
        // setting type (username, email) and value parameters
        query.setParameter(type, value);
        // returning object
        return query.uniqueResultOptional();
    }
}
