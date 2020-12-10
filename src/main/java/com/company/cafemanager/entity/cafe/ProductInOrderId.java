package com.company.cafemanager.entity.cafe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ProductInOrderId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    public ProductInOrderId() {
    }

    public ProductInOrderId(Product product, Order order) {
        this.product = product;
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
