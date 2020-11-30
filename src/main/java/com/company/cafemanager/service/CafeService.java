package com.company.cafemanager.service;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Service interface
 * @param <T> Type of Entity
 * @param <I> Id type
 */
public interface CafeService<T extends Identified<I> & Deletable, I extends Serializable> {
    T get(final I id);

    List<T> getAll();

    List<T> getAllFromRange(final int startIndex, final int count);

    T save(final T t);

    T update(final T t);

    T delete(final T t);
}