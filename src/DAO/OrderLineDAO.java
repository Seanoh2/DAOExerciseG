/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dtos.Order;
import Dtos.OrderLine;
import interfaces.OrderLineDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Seanoh
 */
public class OrderLineDAO extends DAO implements OrderLineDAOInterface {

    @Override
    public ArrayList<OrderLine> getOrderLinesByOrder(Order order) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        OrderDAO orderDAO = null;
        ProductDAO productDAO = null;
        OrderLine orderLine = null;
        ArrayList<OrderLine> orderLines = new ArrayList();

        try {
            con = getConnection();
            String query = "SELECT * FROM orderdetails WHERE orderNumber = ?";

            ps = con.prepareStatement(query);

            ps.setInt(1, order.getOrderNumber());
            rs = ps.executeQuery();

            while (rs.next()) {
                orderLine = new OrderLine();
                orderLine.setOrder(orderDAO.getOrderByOrderNumber(rs.getInt("OrderNumber")));
                orderLine.setProduct(productDAO.getProductByCode(rs.getString("productCode")));
                orderLine.setQuantityOrdered(rs.getInt("quantityOrdered"));
                orderLine.setPriceEach(rs.getDouble("priceEach"));
                orderLine.setOrderLineNumber(rs.getInt("orderLineNumber"));
                orderLines.add(orderLine);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getOrderLinesByOrder() method");
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
                System.out.println("Exception occured in the finally section in the getOrderLinesByOrder() method");
            }
        }

        return orderLines;

    }

}
