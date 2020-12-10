package com.company.cafemanager.entity.user;

import com.company.cafemanager.entity.Identified;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "role")
public class Role implements Identified<ERole> {

    @Id
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", length = 7, nullable = false)
    ERole roleName;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    List<User> users;

    public Role() {
    }

    public Role(@NotNull final ERole roleName) {
        this.roleName = roleName;
    }

    @Override
    public ERole getId() {
        return getRoleName();
    }

    public void setId(ERole roleName) {
        setRoleName(roleName);
    }

    public ERole getRoleName() {
        return roleName;
    }

    public void setRoleName(ERole roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return this.roleName == role.roleName;
    }

    @Override
    public int hashCode() {
        return roleName.hashCode();
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
