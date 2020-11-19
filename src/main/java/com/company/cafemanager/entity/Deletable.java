package com.company.cafemanager.entity;

import java.time.LocalDateTime;

/**
 * Deletable interface for objects that have deleted column in db
 */
public interface Deletable {
    LocalDateTime getDeleted();

    void setDeleted(LocalDateTime deleted);
}
