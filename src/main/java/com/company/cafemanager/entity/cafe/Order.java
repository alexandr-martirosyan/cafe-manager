package com.company.cafemanager.entity.cafe;


import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@javax.persistence.Table(name = "order")
@JsonIgnoreProperties(value = {
        "created",
        "updated",
        "deleted"
})
public class Order implements Deletable, Identified<UUID> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    private UUID id;

    @NotNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "table_id", nullable = false)
    private Table table;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 9, nullable = false)
    private OrderStatus status;

    @CreationTimestamp
    @Column(name = "created", updatable = false, nullable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "deleted")
    private LocalDateTime deleted;

    @OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductInOrder> productInOrders = new HashSet<>();

    public Order() {
    }

    public Order(
        Table table,
        OrderStatus status
    ) {
        this.table = table;
        this.status = status;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(Set<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
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
