/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author Seanoh
 */
public class Order {
    private int orderNumber;
    private String orderDate;
    private String requiredDate;
    private String shippedDate;
    private String status;
    private String comments;
    private int customerNumber;

    public Order(int orderNumber, String orderDate, String requiredDate, String shippedDate, String status, String comments, int customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }
    
    public Order() {
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public String getComments() {
        return comments;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.orderNumber;
        hash = 53 * hash + this.customerNumber;
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
        final Order other = (Order) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (this.customerNumber != other.customerNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate + ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", customerNumber=" + customerNumber + '}';
    }
    
    
}
