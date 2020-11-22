package com.company.cafemanager.service;

import com.company.cafemanager.dao.Dao;
import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class CafeServiceImpl<T extends Identified<I> & Deletable, I extends Serializable> implements CafeService<T, I> {
    private final Dao<T, I> dao;
    protected final Class<T> clazz;

    public CafeServiceImpl(final Dao<T, I> dao, final Class<T> clazz) {
        this.dao = dao;
        this.clazz = clazz;
    }

    protected Optional<T> checkOptionalValue(Optional<T> t, String value) {
        String className = clazz.getSimpleName();
        if (t.isEmpty()) {
            throw new NullPointerException("there is no " + className + "with this " + value + "!");
        }
        if (t.get().getDeleted() != null) {
            throw new IllegalArgumentException(className + " is deleted");
        }
        return t;
    }

    @Override
    @Transactional
    public T get(final I id) {
        return checkOptionalValue(dao.get(id), "id").get();
    }

    @Override
    @Transactional
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public List<T> getAllFromRange(final int startIndex, final int count) {
        return dao.getAllFromRange(startIndex, count);
    }

    @Override
    @Transactional
    public T save(final T t) {
        return dao.save(t);
    }

    @Override
    @Transactional
    public T update(final T t) {
        return dao.update(t);
    }

    @Override
    @Transactional
    public T delete(final T t) {
        return dao.delete(t);
    }
}
