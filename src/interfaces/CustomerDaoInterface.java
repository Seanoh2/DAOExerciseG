/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Dtos.Customer;
import java.util.ArrayList;

/**
 *
 * @author Seanoh
 */
public interface CustomerDaoInterface {
    public ArrayList<Customer> selectCustomerByName(String name);
    public ArrayList<Customer> selectCustomerContainingName(String name);
    public Customer findCustomerbyId(int customerNumber);
    public boolean addCustomer(Customer c);
    
}
