/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Dtos.Order;
import Dtos.OrderLine;
import java.util.ArrayList;

/**
 *
 * @author Seanoh
 */
public interface OrderLineDAOInterface {
    public ArrayList<OrderLine> getOrderLinesByOrder(Order order);
    
}
