package com.company.cafemanager.dao;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;

import java.io.Serializable;
import java.util.List;

/**
 * Data access interface
 *
 * @param <T> Type of entity
 * @param <I> Id type
 */

public interface Dao<T extends Identified<I> & Deletable, I extends Serializable> {
    T get(final I id);

    List<T> getAll();

    List<T> getAllFromRange(final int startIndex, final int count);

    T save(final T t);

    T update(final T t);

    T delete(final T t);
}
