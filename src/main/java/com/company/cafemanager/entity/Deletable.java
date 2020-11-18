package com.company.cafemanager.entity;

import java.time.LocalDateTime;

public interface Deletable {
    LocalDateTime getDeleted();

    void setDeleted(LocalDateTime deleted);
}
