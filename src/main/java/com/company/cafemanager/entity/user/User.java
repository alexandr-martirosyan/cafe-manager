package com.company.cafemanager.entity.user;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(
    name = "user",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username", name = "user_username"),
        @UniqueConstraint(columnNames = "email", name = "user_email")
    }
)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements Deletable, Identified<UUID> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    UUID id;

    @NotBlank
    @Column(name = "first_name", length = 20, nullable = false)
    String firstName;

    @NotBlank
    @Column(name = "last_name", length = 20, nullable = false)
    String lastName;

    @Size(min = 8, max = 30)
    @Column(name = "username", length = 30, unique = true, updatable = false, nullable = false)
    String username;

    @NotBlank
    @Size(min = 8, max = 50)
    @Column(name = "password", length = 50, nullable = false)
    String password;

    @Email
    @Column(name = "email", unique = true, updatable = false, length = 30)
    String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 6, nullable = false)
    Gender gender;

    @NotNull
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_role",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "role_name")}
    )
    Set<Role> roles;

    @CreationTimestamp
    @Column(name = "created", updatable = false, nullable = false)
    LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated", nullable = false)
    LocalDateTime updated;

    @Column(name = "deleted")
    LocalDateTime deleted;

    protected User() {
    }

    protected User(
        String firstName,
        String lastName,
        String username,
        String password,
        String email,
        Gender gender,
        Set<Role> roles
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.roles = roles;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public LocalDateTime getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(LocalDateTime deleted) {
        this.deleted = deleted;
    }

    public void addRole(Role role) {
        roles.add(role);
    }
}
