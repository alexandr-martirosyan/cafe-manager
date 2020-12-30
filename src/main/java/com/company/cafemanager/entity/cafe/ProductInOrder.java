package com.company.cafemanager.entity.cafe;

import com.company.cafemanager.entity.Deletable;
import com.company.cafemanager.entity.Identified;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "`product_in_order`")
@AssociationOverrides({
    @AssociationOverride(name = "id.product", joinColumns = @JoinColumn(name = "`product_id`")),
    @AssociationOverride(name = "id.order", joinColumns = @JoinColumn(name = "`order_id`"))
})
@JsonIgnoreProperties(value = {
        "created",
        "updated",
        "deleted",
        "order"
})
public class ProductInOrder implements Deletable, Identified<ProductInOrderId> {

    @JsonIgnore
    @EmbeddedId
    private ProductInOrderId id = new ProductInOrderId();

    @NotNull
    @Min(1)
    @Column(name = "`amount`", nullable = false)
    private int amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "`status`", length = 9, nullable = false)
    private ProductInOrderStatus status;

    @CreationTimestamp
    @Column(name = "`created`", updatable = false, nullable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "`updated`", nullable = false)
    private LocalDateTime updated;

    @Column(name = "`deleted`")
    private LocalDateTime deleted;

    public ProductInOrder() {
    }

    public ProductInOrder(
        ProductInOrderId id
    ) {
        this.id = id;
        this.amount = 1;
        this.status = ProductInOrderStatus.ACTIVE;
    }

    public ProductInOrder(
        ProductInOrderId id,
        int amount
    ) {
        this.id = id;
        this.amount = amount;
        this.status = ProductInOrderStatus.ACTIVE;
    }

    @Transient
    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    @Transient
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    @Override
    public ProductInOrderId getId() {
        return id;
    }

    public void setId(ProductInOrderId id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ProductInOrderStatus getStatus() {
        return status;
    }

    public void setStatus(ProductInOrderStatus status) {
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

    @Override
    public String toString() {
        return "ProductInOrder{" +
            "primaryKey=" + id +
            ", amount=" + amount +
            ", created=" + created +
            ", updated=" + updated +
            ", deleted=" + deleted +
            '}';
    }

}
