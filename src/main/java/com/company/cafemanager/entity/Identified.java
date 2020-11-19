package com.company.cafemanager.entity;

/**
 * Identified interface for objects with ID
 * @param <T> Type of ID
 */
public interface Identified<T> {
    T getId();
}
