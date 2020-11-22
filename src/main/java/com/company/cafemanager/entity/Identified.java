package com.company.cafemanager.entity;

import java.io.Serializable;

/**
 * Identified interface for objects with ID
 * @param <T> Type of ID
 */
public interface Identified<T extends Serializable> {
    T getId();
}
