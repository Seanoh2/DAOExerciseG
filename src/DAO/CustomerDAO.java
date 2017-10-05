/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfaces.CustomerDaoInterface;
import Dtos.Customer;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Seanoh
 */
public class CustomerDAO extends DAO implements CustomerDaoInterface {

    @Override
    public ArrayList<Customer> selectCustomerByName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;
        ArrayList<Customer> customerList = new ArrayList();

        try {
            con = getConnection();
            String query = "SELECT * FROM customers WHERE customerName = ?";
            ps = con.prepareStatement(query);

            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                // Get the pieces of a customer from the resultset
                customer.setCustomerNumber(rs.getInt("customerNumber"));
                customer.setCreditLimit(rs.getDouble("creditLimit"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setPhone(rs.getString("phone"));
                customerList.add(customer);

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the selectCustomerByName() method");
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
                System.out.println("Exception occured in the finally section in the selectCustomerByName() method");
            }
        }

        return customerList;

    }

    @Override
    public ArrayList<Customer> selectCustomerContainingName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;
        ArrayList<Customer> customerList = new ArrayList();
        String search = '%' + name + '%';

        try {
            con = getConnection();
            String query = "SELECT * FROM customers WHERE customerName LIKE ?";
            ps = con.prepareStatement(query);

            ps.setString(1, search);
            rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                // Get the pieces of a customer from the resultset
                customer.setCustomerNumber(rs.getInt("customerNumber"));
                customer.setCreditLimit(rs.getDouble("creditLimit"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setPhone(rs.getString("phone"));
                customerList.add(customer);

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the selectCustomerContainingName() method");
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
                System.out.println("Exception occured in the finally section in the selectCustomerByName() method");
            }
        }

        return customerList;

    }

    @Override
    public Customer findCustomerbyId(int customerNumber) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;

        try {
            con = getConnection();
            String query = "SELECT * FROM customers WHERE customerNumber = ?";
            ps = con.prepareStatement(query);

            // Fill in the blanks, i.e. parameterize the query
            ps.setInt(1, customerNumber);

            // Execute the query
            rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                // Get the pieces of a customer from the resultset
                customer.setCustomerNumber(rs.getInt("customerNumber"));
                customer.setCreditLimit(rs.getDouble("creditLimit"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setPhone(rs.getString("phone"));
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
                System.out.println("Exception occured in the finally section in the selectCustomerByName() method");
            }
        }

        return customer;

    }

    @Override
    public boolean addCustomer(Customer c) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs = 0;
        Customer customer = null;
        Boolean result = null;

        try {
            con = getConnection();
            String query = "INSERT INTO customers VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);

            int customerNumber = c.getCustomerNumber();
            String customerName = c.getCustomerName();
            String contactLastName = c.getContactLastName();
            String contactFirstName = c.getContactFirstName();
            String phoneNumber = c.getPhone();
            String addressLine1 = c.getAddressLine1();
            String addressLine2 = c.getAddressLine2();
            String city = c.getCity();
            String state = c.getState();
            String postalCode = c.getPortalCode();
            String country = c.getCountry();
            int salesRep = c.getSalesRepNum();
            double creditLimit = c.getCreditLimit();

            // Fill in the blanks, i.e. parameterize the query
            ps.setInt(1, customerNumber);
            ps.setString(2, customerName);
            ps.setString(3, contactLastName);
            ps.setString(4, contactFirstName);
            ps.setString(5, phoneNumber);
            ps.setString(6, addressLine1);
            ps.setString(7, addressLine2);
            ps.setString(8, city);
            ps.setString(9, state);
            ps.setString(10, postalCode);
            ps.setString(11, country);
            ps.setInt(12, salesRep);
            ps.setDouble(13, creditLimit);

            // Execute the query
            rs = ps.executeUpdate();

        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Constraint Exception occurred: " + e.getMessage());
            // Set the rowsAffected to -1, this can be used as a flag for the display section
            rs = -1;

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
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    closeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the selectCustomerByName() method");
            }
        }

        if (rs > 0) {
            result = true;
        } else {
            result = false;
        }

        return result;

    }

}
