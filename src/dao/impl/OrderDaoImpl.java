/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.OrderDao;
import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 良匠
 */
public class OrderDaoImpl implements OrderDao{
    public Connection con=null;
    public PreparedStatement ps = null;
    public OrderDaoImpl(Connection con){
        this.con=con;
    }
    @Override
    public int addorder(Order order) {
        try{
            String sql="insert into orders values (?,?,?,?,?)";
            ps=this.con.prepareStatement(sql);
            ps.setString(1,order.getOnum());
            ps.setString(2,order.getGname());
            ps.setString(3,order.getDate());
            ps.setString(4,order.getCodenum());
            ps.setString(5,order.getEmail());
            int rs = ps.executeUpdate();
            return rs;
        }catch(SQLException ex){
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
