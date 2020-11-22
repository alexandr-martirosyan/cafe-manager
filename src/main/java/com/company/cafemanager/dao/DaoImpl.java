package com.company.cafemanager.dao;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public abstract class DaoImpl<T extends Identified<I> & Deletable, I extends Serializable> implements Dao<T, I> {

    // define field for accessing classname and deleted method
    protected final Class<T> clazz;
    // define field for entity-manager
    protected final EntityManager entityManager;

    public DaoImpl(final EntityManager entityManager, final Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    @Override
    public Optional<T> get(final I id) {
        // get the current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        // return the object
        return Optional.ofNullable(session.get(clazz, id));
    }

    private Query<T> getAllQuery() {
        // get the current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        // get all not deleted objects
        String className = clazz.getSimpleName();
        String hql = String.format("from %s where %s.deleted is null", className, className);
        return (Query<T>) session.createQuery(hql);
    }

    @Override
    public List<T> getAll() {
        Query<T> query = getAllQuery();
        return query.list();
    }

    @Override
    public List<T> getAllFromRange(final int startIndex, final int count) {
        Query<T> query = getAllQuery();
        query.setFirstResult(startIndex);
        query.setMaxResults(count);
        return query.list();
    }

    @Override
    public T save(final T t) {
        // get the current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        // save the object
        session.save(t);
        return t;
    }

    @Override
    public T update(final T t) {
        // get the current Hibernate Session
        Session session = entityManager.unwrap(Session.class);
        // update the object
        session.update(t);
        return t;
    }

    @Override
    public T delete(final T t) {
        // check if object is already deleted or not
        if (t.getDeleted() != null) {
            throw new IllegalArgumentException(clazz.getSimpleName() + "is already deleted in " + t.getDeleted());
        }
        // change deleted time to now() and save it in db
        t.setDeleted(LocalDateTime.now());
        update(t);
        return t;
    }
}
