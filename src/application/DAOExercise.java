/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import DAO.CustomerDAO;
import Dtos.Customer;
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
        ArrayList<Customer> relatedC = new ArrayList();

        System.out.println("Please enter your name: ");
        String userInput = input.nextLine();
        relatedC = customer.selectCustomerContainingName(userInput);
        for (Customer c : relatedC) {
            System.out.println(c.toString());
        }
        
        System.out.println("Please enter custome rnumber to view orders: ");
        int customerNumber = input.nextInt();
        

    }
}
