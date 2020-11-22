package com.company.cafemanager.dao;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class DaoImpl<T extends Identified<I> & Deletable, I extends Serializable> implements Dao<T, I> {

    // define field for accessing classname and deleted method
    protected Class<T> clazz;
    // define field for entity-manager
    protected final EntityManager entityManager;

    @Autowired
    public DaoImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Optional<T> get(I id) {
        // get the current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        // return the object
        return Optional.ofNullable(session.get(clazz, id));
    }

    @Override
    public List<T> getAll() {
        // get the current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        // get all not deleted objects
        String className = clazz.getSimpleName();
        String hql = String.format("from %s where %s.deleted is null", className, className);
        Query<T> query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public List<T> getAllFromRange(int startIndex, int count) {
        return null;
    }

    @Override
    public T save(T t) {
        // get the current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        // save the object
        session.save(t);
        return t;
    }

    @Override
    public T update(T t) {
        // get the current Hibernate Session
        Session session = entityManager.unwrap(Session.class);
        // update the object
        session.update(t);
        return t;
    }

    @Override
    public T delete(T t) {
        // change deleted time to now() and save it in db
        t.setDeleted(LocalDateTime.now());
        update(t);
        return t;
    }
}
