package com.company.cafemanager.entity.cafe;

import com.company.cafemanager.entity.Deletable;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_in_order")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.product", joinColumns = @JoinColumn(name = "product_id")),
    @AssociationOverride(name = "primaryKey.order", joinColumns = @JoinColumn(name = "order_id"))
})
public class ProductInOrder implements Deletable {

    @EmbeddedId
    private ProductInOrderId primaryKey = new ProductInOrderId();

    @NotNull
    @Column(name = "amount", nullable = false)
    private int amount;

    @CreationTimestamp
    @Column(name = "created", updatable = false, nullable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "deleted")
    private LocalDateTime deleted;

    public ProductInOrder() {
    }

    public ProductInOrder(
        ProductInOrderId primaryKey,
        int amount
    ) {
        this.primaryKey = primaryKey;
        this.amount = amount;
    }

    @Transient
    public Product getProduct() {
        return primaryKey.getProduct();
    }

    public void setProduct(Product product) {
        primaryKey.setProduct(product);
    }

    @Transient
    public Order getOrder() {
        return primaryKey.getOrder();
    }

    public void setOrder(Order order) {
        primaryKey.setOrder(order);
    }

    public ProductInOrderId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ProductInOrderId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
            "primaryKey=" + primaryKey +
            ", amount=" + amount +
            ", created=" + created +
            ", updated=" + updated +
            ", deleted=" + deleted +
            '}';
    }
}
