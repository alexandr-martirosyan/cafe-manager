package com.company.cafemanager.dao;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;

import java.util.List;

/**
 * @param <T> Type
 * @param <I> Id Type
 */
public interface Dao<T extends Identified<I> & Deletable, I> {
    T get(final I id);

    List<T> getAll();

    List<T> getAllFromRange(final int startIndex, final int count);

    T save(final T t);

    T update(final T t);

    T delete(final T t);
}
