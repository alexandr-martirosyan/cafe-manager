package com.company.cafemanager.dao.user;

import com.company.cafemanager.dao.DaoImpl;
import com.company.cafemanager.entity.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.UUID;

public abstract class UserDaoImpl<T extends User> extends DaoImpl<T, UUID> implements UserDao<T> {

    public UserDaoImpl(final EntityManager entityManager, final Class<T> clazz) {
        super(entityManager, clazz);
    }

    @Override
    public Optional<T> getByUsername(final String username) {
        return getBy("username", username);
    }

    @Override
    public Optional<T> getByEmail(final String email) {
        return getBy("email", email);
    }

    private Optional<T> getBy(final String type, final String value) {
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
