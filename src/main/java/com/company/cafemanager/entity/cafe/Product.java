package com.company.cafemanager.entity.cafe;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product implements Deletable, Identified<UUID> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    private UUID id;

    @NotBlank
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @NotNull
    @Column(name = "price", precision = 7, scale = 3, nullable = false)
    private double price;

    @NotNull
    @Column(name = "weight", precision = 5, scale = 2, nullable = false)
    private double weight;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "cook_duration")
    private Duration cookDuration;

    @CreationTimestamp
    @Column(name = "created", updatable = false, nullable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "deleted")
    private LocalDateTime deleted;

    @OneToMany(mappedBy = "id.product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductInOrder> productInOrders = new ArrayList<>();

    public Product() {
    }

    public Product(
        String name,
        double price,
        double weight,
        String description
    ) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.description = description;
    }

    public List<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(List<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }

    public Product(
        String name,
        double price,
        double weight,
        String description,
        Duration cookDuration
    ) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.description = description;
        this.cookDuration = cookDuration;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getCookDuration() {
        return cookDuration;
    }

    public void setCookDuration(Duration cookDuration) {
        this.cookDuration = cookDuration;
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
