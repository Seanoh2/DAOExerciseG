/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.OrderLineDAO;
import Dtos.Customer;
import Dtos.Order;
import Dtos.OrderLine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Seanoh
 */
public class DAOExercise {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CustomerDAO customer = new CustomerDAO();
        OrderLineDAO orderLine = new OrderLineDAO();
        OrderDAO order = new OrderDAO();
        ArrayList<Customer> relatedC = new ArrayList();

        System.out.println("Please enter your name: ");
        String userInput = input.nextLine();
        relatedC = customer.selectCustomerContainingName(userInput);
        for (Customer c : relatedC) {
            System.out.println("Customer Name: " + c.getCustomerName());
            System.out.println("Customer Number : " + c.getCustomerNumber());
            System.out.println("");
        }

        System.out.println("Please enter customer number to view orders: ");
        int customerNumber = input.nextInt();

        for (Order r : order.getOrdersByCustomerID(customerNumber)) {
            System.out.println("Order Number: " + r.getOrderNumber());
            System.out.println("Order Shipping Date: " + r.getShippedDate());
            System.out.println("Order Status: " + r.getStatus());
            System.out.println("");
            for (OrderLine o : orderLine.getOrderLinesByOrder(r)) {
                System.out.println("PRODUCT - " + o.getProduct().getName() + " : ");
                System.out.println("Quantity Ordered: " + o.getQuantityOrdered());
                System.out.println("MSRP: " + o.getProduct().getMsrp());
                System.out.println("Vendor: " + o.getProduct().getVendor());
                System.out.println("");
            }
            System.out.println("");
        }

    }
}
