package com.company.cafemanager.entity.user;


import com.company.cafemanager.entity.cafe.Table;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@javax.persistence.Table(name = "waiter")
public class Waiter extends User {

    @OneToMany(mappedBy = "waiter")
    private List<Table> tables = new ArrayList<>();

    public Waiter() {
    }

    public Waiter(
        String firstName,
        String lastName,
        String username,
        String password,
        String email,
        Gender gender
    ) {
        super(
            firstName,
            lastName,
            username,
            password,
            email,
            gender
        );
    }

    public Waiter(
        String firstName,
        String lastName,
        String username,
        String password,
        String email,
        Gender gender,
        List<Table> tables
    ) {
        super(
            firstName,
            lastName,
            username,
            password,
            email,
            gender
        );
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "Waiter{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", gender=" + gender +
            ", created=" + created +
            ", updated=" + updated +
            ", deleted=" + deleted +
            '}';
    }
}
