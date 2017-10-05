/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author grahamm
 */
public class Customer 
{
    /*
  `customerNumber` int(11) NOT NULL,
  `customerName` varchar(50) NOT NULL,
  `contactLastName` varchar(50) NOT NULL,
  `contactFirstName` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `addressLine1` varchar(50) NOT NULL,
  `addressLine2` varchar(50) default NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) default NULL,
  `postalCode` varchar(15) default NULL,
  `country` varchar(50) NOT NULL,
  `salesRepEmployeeNumber` int(11) default NULL,
  `creditLimit` double default NULL,
    */
    
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String portalCode;
    private String country;
    private int salesRepNum;
    private double creditLimit;

    public Customer() {
    }

    public Customer(int customerNumber, String customerName, String contactLastName, String contactFirstName, String phone, String addressLine1, String addressLine2, String city, String state, String portalCode, String country, int salesRepNum, double creditLimit) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.portalCode = portalCode;
        this.country = country;
        this.salesRepNum = salesRepNum;
        this.creditLimit = creditLimit;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPortalCode() {
        return portalCode;
    }

    public String getCountry() {
        return country;
    }

    public int getSalesRepNum() {
        return salesRepNum;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPortalCode(String portalCode) {
        this.portalCode = portalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSalesRepNum(int salesRepNum) {
        this.salesRepNum = salesRepNum;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.customerNumber;
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
        final Customer other = (Customer) obj;
        if (this.customerNumber != other.customerNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName=" + contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", portalCode=" + portalCode + ", country=" + country + ", salesRepNum=" + salesRepNum + ", creditLimit=" + creditLimit + '}';
    }
    
    
}
