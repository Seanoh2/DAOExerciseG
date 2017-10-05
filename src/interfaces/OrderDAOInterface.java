/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Dtos.Order;
import java.util.ArrayList;

/**
 *
 * @author Seanoh
 */
public interface OrderDAOInterface {
    public ArrayList<Order> getOrdersByCustomerID(int customerNumber);
    public Order getOrderByOrderNumber(int orderNumber);
}
