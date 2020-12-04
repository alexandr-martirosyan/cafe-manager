package com.company.cafemanager.entity.user;


import com.company.cafemanager.entity.cafe.Table;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "waiter")
public class Waiter extends User {

    @OneToMany(mappedBy = "waiter", fetch = FetchType.LAZY)
    private List<Table> tables = new ArrayList<>();

    public Waiter() {
    }

    public Waiter(
        String firstName,
        String lastName,
        String username,
        String password,
        String email,
        Gender gender,
        Set<Role> roles
    ) {
        super(
            firstName,
            lastName,
            username,
            password,
            email,
            gender,
            roles
        );
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
            ", roles=" + roles +
            ", created=" + created +
            ", updated=" + updated +
            ", deleted=" + deleted +
            ", tables=" + tables +
            '}';
    }
}
