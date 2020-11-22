package com.company.cafemanager.service;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class ServiceImpl<T extends Identified<I> & Deletable, I extends Serializable> implements Service<T, I> {
    @Override
    public Optional<T> get(I id) {
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public List<T> getAllFromRange(int startIndex, int count) {
        return null;
    }

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public T delete(T t) {
        return null;
    }
}
