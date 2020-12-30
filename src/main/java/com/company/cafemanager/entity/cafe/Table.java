package com.company.cafemanager.entity.cafe;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;
import com.company.cafemanager.entity.user.Waiter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@javax.persistence.Table(name = "`table`")
@JsonIgnoreProperties(value = {
        "created",
        "updated",
        "deleted"
})
public class Table implements Deletable, Identified<UUID> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "`id`", updatable = false, columnDefinition = "uuid")
    private UUID id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "`waiter_id`")
    private Waiter waiter;

    @OneToMany(mappedBy = "table", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @NotNull
    @Column(name = "`capacity`", nullable = false)
    private int capacity;

    @CreationTimestamp
    @Column(name = "`created`", updatable = false, nullable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "`updated`", nullable = false)
    private LocalDateTime updated;

    @Column(name = "`deleted`", nullable = true)
    private LocalDateTime deleted;

    public Table() {
    }

    public Table(@NotNull int capacity) {
        this.capacity = capacity;
    }

    public Table(
        Waiter waiter,
        int capacity
    ) {
        this.waiter = waiter;
        this.capacity = capacity;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
}
