/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Objects;

/**
 *
 * @author Seanoh
 */
public class OrderLine {
    private Order order;
    private Product product;
    private int quantityOrdered;
    private Double priceEach;
    private int orderLineNumber;

    public OrderLine(Order order, Product product, int quantityOrdered, Double priceEach, int orderLineNumber) {
        this.order = order;
        this.product = product;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }
    
    public OrderLine() {
        
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public Double getPriceEach() {
        return priceEach;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public void setPriceEach(Double priceEach) {
        this.priceEach = priceEach;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.order);
        hash = 79 * hash + Objects.hashCode(this.product);
        hash = 79 * hash + this.orderLineNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderLine other = (OrderLine) obj;
        if (this.orderLineNumber != other.orderLineNumber) {
            return false;
        }
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderLine{" + "order=" + order + ", product=" + product + ", quantityOrdered=" + quantityOrdered + ", priceEach=" + priceEach + ", orderLineNumber=" + orderLineNumber + '}';
    }
    
    
    
}
