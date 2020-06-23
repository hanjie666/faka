package dao.impl;

import dao.UserDao;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 良匠
 */
public class UserDaoImpl implements UserDao{
    public Connection con=null;
    public PreparedStatement ps = null;
    public UserDaoImpl(Connection con){
        this.con=con;
    }

    @Override
    public User userLogin(User user) {
       try {
         String sql="select * from users where username = ? and password = ?";
         ps = this.con.prepareStatement(sql);
         ps.setString(1,user.getUsername());
         ps.setString(2,user.getPassword());
         ResultSet rs = ps.executeQuery();
         User user1 = new User();
         while(rs.next()){
               user1.setUsername(rs.getString("username"));
               user1.setPassword(rs.getString("password"));
               user1.setMoney(rs.getInt("money"));
         }
         return user1;
         
     } catch (SQLException ex) {
         Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
     } 
       return null;
    }

    @Override
    public int updateUserMoney(User user) {
         try{
            String sql = "update users set money = ?  where username = ?";
            ps=this.con.prepareStatement(sql);
            ps.setInt(1,user.getMoney());
            ps.setString(2,user.getUsername());
            int ss = ps.executeUpdate();
            if(ss==1){
                return 1;
            }else{
                return 0;
            }
        }catch(SQLException ex){
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
          return 0;
    }

    @Override
    public int getUserMoneyByUsername(String username) {
        try {
         String sql="select money from users where username = ?";
         ps = this.con.prepareStatement(sql);
         ps.setString(1,username);
         ResultSet rs = ps.executeQuery();
         User user1 = new User();
         while(rs.next()){
               return Integer.parseInt(rs.getString("money"));
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
     } 
       return 0;
    }

    @Override
    public int addUserMoney(int money,String username) {
        try {
            String sql = "update users set money = money + ? where username = ?";
            ps=this.con.prepareStatement(sql);
            ps.setInt(1,money);
            ps.setString(2,username);
            int ss = ps.executeUpdate();
            return ss;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
          return 0;
        
    }
}
