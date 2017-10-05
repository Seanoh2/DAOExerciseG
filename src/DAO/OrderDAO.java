/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dtos.Order;
import interfaces.OrderDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Seanoh
 */
public class OrderDAO extends DAO implements OrderDAOInterface {

    @Override
    public ArrayList<Order> getOrdersByCustomerID(int customerNumber) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order order = null;
        ArrayList<Order> orders = new ArrayList();

        try {
            con = getConnection();
            String query = "SELECT * FROM orders WHERE customerNumber = ?";
            ps = con.prepareStatement(query);

            // Fill in the blanks, i.e. parameterize the query
            ps.setInt(1, customerNumber);

            // Execute the query
            rs = ps.executeQuery();

            while (rs.next()) {
                order = new Order();

                order.setOrderNumber(rs.getInt("orderNumber"));
                order.setOrderDate(rs.getString("orderDate"));
                order.setRequiredDate(rs.getString("requiredDate"));
                order.setShippedDate(rs.getString("shippedDate"));
                order.setStatus(rs.getString("status"));
                order.setCustomerNumber(rs.getInt("customerNumber"));
                orders.add(order);
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } // Now that the program has completed its database access component, 
        // close the open access points (resultset, preparedstatement, connection)
        // Remember to close them in the OPPOSITE ORDER to how they were opened
        // Opening order: Connection -> PreparedStatement -> ResultSet
        // Closing order: ResultSet -> PreparedStatement -> Connection
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    closeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the getOrdersByCustomerId() method");
            }
        }

        return orders;
    }

    @Override
    public Order getOrderByOrderNumber(int orderNumber) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order order = new Order();

        try {
            con = getConnection();
            String query = "SELECT * FROM orders WHERE orderNumber = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, orderNumber);

            rs = ps.executeQuery();

            while (rs.next()) {
                order = new Order();

                order.setOrderNumber(rs.getInt("orderNumber"));
                order.setOrderDate(rs.getString("orderDate"));
                order.setRequiredDate(rs.getString("requiredDate"));
                order.setShippedDate(rs.getString("shippedDate"));
                order.setStatus(rs.getString("status"));
                order.setCustomerNumber(rs.getInt("customerNumber"));
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception occured:" + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Excpetion occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    closeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the getOrderByOrderNumber() method");
            }
        }

        return order;
    }

}
