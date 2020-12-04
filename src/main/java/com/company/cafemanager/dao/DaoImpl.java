package com.company.cafemanager.dao;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;
import org.hibernate.ObjectDeletedException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public abstract class DaoImpl<T extends Identified<I> & Deletable, I extends Serializable> implements Dao<T, I> {

    // define field for accessing classname and deleted method
    protected final Class<T> clazz;
    // define field for entity-manager
    protected final EntityManager entityManager;

    protected DaoImpl(final EntityManager entityManager, final Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    protected T checkGetValue(T t, String constraintName) {
        // get the class name
        String className = clazz.getSimpleName();
        // check if gotten object is null or not
        if (t == null) {
            throw new NullPointerException("there is no " + className + " with this " + constraintName + "!");
        }
        // check if gotten object is already deleted or not
        if (t.getDeleted() != null) {
            throw new ObjectDeletedException("Object is already deleted", t.getId(), className);
        }
        return t;
    }

    @Override
    public T get(final I id) {
        // get the current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        // calling checkGetValue method
        return checkGetValue(session.get(clazz, id), "id");
    }

    private Query<T> getAllQuery() {
        // get the current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        // get all not deleted objects
        String className = clazz.getSimpleName();
        String hql = String.format("from %s obj where obj.deleted is null", className);
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
        T entity = get(t.getId());
        if (entity.getDeleted() != null) {
            throw new ObjectDeletedException(clazz.getSimpleName() + "is already deleted in " + t.getDeleted(), t.getId(), clazz.getSimpleName());
        }
        // get the current Hibernate Session
        Session session = entityManager.unwrap(Session.class);
        // clear the session
        session.clear();
        // update the object
        session.update(t);
        return t;
    }

    @Override
    public T delete(final T t) {
        // check if object is already deleted or not
        T entity = get(t.getId());
        if (entity.getDeleted() != null) {
            throw new ObjectDeletedException(clazz.getSimpleName() + "is already deleted in " + entity.getDeleted(), entity.getId(), clazz.getSimpleName());
        }
        // change deleted time to now() and save it in db
        entity.setDeleted(LocalDateTime.now());
        entityManager.unwrap(Session.class).update(entity);
        return entity;
    }
}
