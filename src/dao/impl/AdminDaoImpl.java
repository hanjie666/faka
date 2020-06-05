/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AdminDao;
import entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 良匠
 */
public class AdminDaoImpl implements AdminDao{
    public Connection con=null;
    public PreparedStatement ps = null;
    public AdminDaoImpl(Connection con){
        this.con=con;
    }
    
    @Override
    public int adminLogin(Admin admin) {
        try {
         String sql="select * from admin where username = ? and password = ?";
         ps = this.con.prepareStatement(sql);
         ps.setString(1,admin.getUsername());
         ps.setString(2,admin.getPassword());
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
               return 1;
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
     return -1;
    }

}
