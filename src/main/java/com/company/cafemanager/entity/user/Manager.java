package com.company.cafemanager.entity.user;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager extends User {
    public Manager() {
    }

    public Manager(
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

    @Override
    public String toString() {
        return "Manager{" +
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
